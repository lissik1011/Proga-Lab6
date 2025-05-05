package command_process.commands;

import java.util.Scanner;

public class CommandManeger{

    MakeListOfCommands list = new MakeListOfCommands();

    public void startProg(Scanner scan){
        while (true){
            System.out.print("-> ");
            if (scan.hasNextLine()){
                String scancom = scan.nextLine().trim();
                if (scancom.contains("exit")){
                    try {
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalStateException e) {
                        break;
                    }
                } else if (!validCom(scancom)) {
                    System.out.println("Лишнее количество аргументов. Введите help, чтобы узнать доступные команды.");
                }
                else if (thisIsCommand(takeCommand(scancom)[0])){
                    String com = takeCommand(scancom)[0];
                    String arg = takeCommand(scancom)[1];
                    try {
                        execute(com, arg, scan);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalStateException e) {
                        break;
                    }
                } else if (scancom.isEmpty()){
                    // continue;
                } else {
                    System.out.println("Команда не распознана. Введите help, чтобы узнать доступные команды.");
                }
            } else {
                break;
            }
        }
        execute("exit", "", scan);
    }

    // Сплитует строку, берет массив команда - аргумент
    public String[] takeCommand(String request){
        String[] com = request.split("\s+");
        if (com.length == 2) return com;
        return new String[] {request, ""};
    }

    // Проверяет, не многовато ли аргументов
    public boolean validCom(String request){
        String[] com = request.split("\s+");
        return com.length <= 2;
    }

    // Проверяет, команда ли введена
    public boolean thisIsCommand(String comand){
        return list.getKeys().contains(comand);
    }

    // Исполняет команду или передает на сервер)
    public void execute(String scancom, String args, Scanner scan) throws IllegalArgumentException{
        Command command = list.takeList().get(scancom);
        command.execute(args, scan);
    }
}
