package command_process.get;

import java.util.Scanner;

import command_process.commands.ExecuteScript;

public class AuthorWeight {
    public static float getAWeight(Scanner scan) {
        while (true) {
            if (ExecuteScript.getScannerType()) {
                System.out.print("Введите вес автора (вещественное число): ");
            }
            if (scan.hasNextLine()) {
                String scanName = scan.nextLine();
                try {
                    float weight = Float.parseFloat(scanName);
                    if (weight > 0)
                        return weight;
                    else
                        System.out.println("Введены неверные данные.");
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                try (scan) {
                }
            }
        }
    }
}
