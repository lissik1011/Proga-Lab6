package command_process.get;

import java.util.Scanner;

import command_process.commands.ExecuteScript;
import command_process.data.Difficulty;

public class DifficultyName {
    public static Difficulty getDif(Scanner scan) {
        boolean bool = true;
        while (bool) {
            if (ExecuteScript.getScannerType()) {
                System.out.print("Выберите трудность\n1 - Hard, 2 - Hopeless, 3 - Terrible: ");
            }
            if (scan.hasNextLine()) {
                String scanName = scan.nextLine();
                try {
                    int dif = Integer.parseInt(scanName);
                    switch (dif) {
                        case 1 -> {
                            return Difficulty.valueOf("HARD");
                        }
                        case 2 -> {
                            return Difficulty.valueOf("HOPELESS");
                        }
                        case 3 -> {
                            return Difficulty.valueOf("TERRIBLE");
                        }
                        default -> System.out.println("Введены неверные данные.");
                    }
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
            return Difficulty.valueOf("HARD");
        }
    }
}
