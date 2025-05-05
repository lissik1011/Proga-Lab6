package command_process.get;

import java.util.Scanner;

import command_process.commands.ExecuteScript;

public class CoordinatesX {
    public static int getCoordX(Scanner scan) {
        boolean bool = true;
        while (bool) {
            if (ExecuteScript.getScannerType()) {
                System.out.print("Введите координату x (целое число): ");
            }
            if (scan.hasNextLine()) {
                String scanName = scan.nextLine();
                try {
                    int coordinatesX = Integer.parseInt(scanName);
                    return coordinatesX;
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
