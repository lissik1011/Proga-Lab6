package command_process.get;

import java.util.Scanner;

import command_process.commands.ExecuteScript;

public class MinimalPoint {
    public static int getMinPoint(Scanner scan) {
        boolean bool = true;
        while (bool) {
            if (ExecuteScript.getScannerType()) {
                System.out.print("Введите минимальный балл (целое число): ");
            }
            if (scan.hasNextLine()) {
                String scanName = scan.nextLine();
                try {
                    int minPoint = Integer.parseInt(scanName);
                    if (minPoint > 0)
                        return minPoint;
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                    if (!ExecuteScript.getScannerType()) {
                        bool = false;
                    }
                }
            } else {
                try (scan) {
                }
            }
        }
        try (scan) {
            return 1;
        }
    }
}
