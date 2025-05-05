import java.util.Scanner;

import command_process.commands.CommandManeger;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        CommandManeger command = new CommandManeger();
        command.startProg(scan);
    }
}
