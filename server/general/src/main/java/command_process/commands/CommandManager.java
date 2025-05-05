package command_process.commands;

public class CommandManager{

    MakeListOfCommands list = new MakeListOfCommands();

    public void processCommand(String commandLine) {
        if (commandLine.isEmpty()) return;

        if (commandLine.equals("exit") || commandLine.equals("bye")) {
            System.out.println("Завершение работы сервера.");
            System.exit(0);
        } else if (!loyalCom(commandLine)) {
            System.out.println("Лишнее количество аргументов.");
        } else if (thisIsCommand(takeCommand(commandLine)[0])) {
            String com = takeCommand(commandLine)[0];
            String arg = takeCommand(commandLine)[1];
            try {
                execute(com, arg);
                History.addHistory(com);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Команда не распознана.");
        }
    }

    public String[] takeCommand(String request){
        String[] com = request.split("\s+");
        if (com.length == 2) return com;
        return new String[] {request, ""};
    }
    public boolean loyalCom(String request){
        String[] com = request.split("\s+");
        return com.length <= 2;
    }

    public boolean thisIsCommand(String comand){
        return list.getKeys().contains(comand);
    }
    private void execute(String scancom, String args) throws IllegalArgumentException{
        Command command = list.takeList().get(scancom);
        command.execute(args, null);
    }
}