import java.util.Scanner;

import command_process.commands.CommandManeger;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // try {        
        //     String file_name = args[0];
        //     File file = new File(file_name);
        //     if (file.exists()) {
        //         String answ = MakeResponse.answer(UDPClient.sendAndReceive(MakeRequest.request(new CreateSendableObject("read_file", file))));
        //         Exit.setFileName(file_name);
        //         if (!answ.isEmpty()) {
        //             System.out.println(answ);
        //         } else {
        //             System.out.println("Ошибка обработки файла. Коллекция пустая.");
        //         }
        //     } else {}
        // } catch (ArrayIndexOutOfBoundsException e){
        // }

        CommandManeger command = new CommandManeger();
        command.startProg(scan);
    }
}
