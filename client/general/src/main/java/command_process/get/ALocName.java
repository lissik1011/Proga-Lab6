package command_process.get;

import java.util.Scanner;

import command_process.commands.ExecuteScript;

public class ALocName {
    public static String getALName(Scanner scan) {
        boolean bool = true;
        while (bool) {
            if (ExecuteScript.getScannerType()) {
                System.out.print("Введите название локации: ");
            }
            if (scan.hasNextLine()) {
                String scanName = scan.nextLine();
                if (validate(scanName)) {
                    return scanName;
                } else {
                    System.out.println(
                            "Введено неверное название, оно пустое или содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
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
            return null;
        }
    }

    private static boolean validate(String name) {
        return !name.isEmpty();
    }
}
