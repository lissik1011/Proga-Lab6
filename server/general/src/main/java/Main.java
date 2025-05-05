import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import accept_connections.UDPServer;
import command_process.commands.Command;
import command_process.commands.CommandManager;
import command_process.commands.Exit;
import command_process.commands.MakeListOfCommands;
import command_process.input.Input;
import command_process.input.TakeCsv;
import read_queries.CreateSendableObject;
import read_queries.MakeQueries;
import send_response.MakeResponse;
import send_response.SendResponse;


public class Main {
    static MakeListOfCommands list = new MakeListOfCommands();

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Введите название файла.");
            System.exit(0);
        }
        try {
            String file_name = args[0];
            Path file = Paths.get(file_name);
            if (Files.exists(file)){
                Input.input(TakeCsv.takeCsv(file));    
                Exit.setFileName(file_name, false);
            } else {
                System.out.println("Файл не найден или нет доступа к нему. Коллекция пустая.");
            }
        } catch (Exception e) {}

        CommandManager commandManager = new CommandManager();
        DatagramChannel channel = UDPServer.createChannel();
        if (channel == null) return;

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        ByteBuffer buffer = ByteBuffer.allocate(65500); 

        System.out.println("Сервер запущен. Ожидание команд и подключений...");

        try {
            while (true) {
                // Обработка команд из консоли
                if (consoleReader.ready()) {
                    String command = consoleReader.readLine().trim();
                    commandManager.processCommand(command);
                }

                // Обработка UDP запросов
                SocketAddress clientAddress = channel.receive(buffer);
                if (clientAddress != null) {
                    buffer.flip();
                    byte[] receivedData = new byte[buffer.remaining()];
                    buffer.get(receivedData);
                    buffer.clear();

                    CreateSendableObject query = MakeQueries.answer(receivedData);
                    Command command = list.takeList().get(query.getCommand());
                    System.out.println("Выполнение команды " + query.getCommand());
                    String response = command.execute(query.getArgs(), query.getLabWork());

                    SendResponse.send(channel, clientAddress, MakeResponse.response(response));
                }
            }
        } catch (IOException  e) {
            System.out.println(e.getMessage());
        }
    }
}