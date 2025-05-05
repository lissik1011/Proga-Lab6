package command_process.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExecuteScript implements Command{
    static boolean scannerTypeIsSystemIn = true;

    @Override 
    public void execute(String args, Scanner scan){
        if (args.isEmpty()) throw new IllegalArgumentException("Введите название файла, который содержит скрипт.");

        try {
            Path file = Paths.get(args);
            if (Files.exists(file)) {
                CommandManeger command = new CommandManeger();

                Scanner scanFile = new Scanner(file);
                scannerTypeIsSystemIn = false;

                while (scanFile.hasNextLine()) {
                    String scancom = scanFile.nextLine();
                    if (command.thisIsCommand(command.takeCommand(scancom)[0])){
                        String com = command.takeCommand(scancom)[0];
                        String arg = command.takeCommand(scancom)[1];

                        if (arg.equals(args)){
                            System.out.println("Скрипт содержит обращение к себе же. Будет выполняться рекурсивно.");
                            break;
                        }
                        try {
                            command.execute(com, arg, scanFile);
                            System.out.println();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (IllegalStateException e) {
                            break;
                        }
                    } else if (scancom.isEmpty()){
                    } else {
                        System.out.println("Команда не распознана. Исполнение скрипта завершено.\nВведите help, чтобы узнать доступные команды.");
                        break;
                    }
                }
                scannerTypeIsSystemIn = true;
            } else {
                System.out.println("Файл не найден или нет доступа к нему.");
            }
        } catch (IOException e) {}
    }

    // Когда тип сканнера true - он содержит в себе Scanner(Sistem.in)
    // А когда false - то Scanner(file)
    public static boolean getScannerType() {
        return scannerTypeIsSystemIn;
    }
}