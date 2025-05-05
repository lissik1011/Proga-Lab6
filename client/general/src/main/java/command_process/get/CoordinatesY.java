package command_process.get;

import java.util.Scanner;

import command_process.commands.ExecuteScript;

public class CoordinatesY {
    public static float getCoordY(Scanner scan) {
        boolean bool = true;
        while (bool) {
            if (ExecuteScript.getScannerType()) {
                System.out.print("Введите координату y (вещественное число): ");
            }
            if (scan.hasNextLine()) {
                String scanName = scan.nextLine();
                try {
                    float coordinatesY = Float.parseFloat(scanName);
                    if (coordinatesY > -868)
                        return coordinatesY;
                    else
                        System.out.println("Введены неверные данные.");
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
