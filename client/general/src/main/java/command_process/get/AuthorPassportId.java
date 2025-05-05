package command_process.get;

import java.util.Scanner;

import command_process.commands.ExecuteScript;

public class AuthorPassportId {
    public static String getAPassportId(Scanner scan) {
        while (true) {
            if (ExecuteScript.getScannerType()) {
                System.out.print("Введите паспортный идентификатор автора: ");
            }
            if (scan.hasNextLine()) {
                String scanName = scan.nextLine();
                if (validate(scanName)) {
                    return scanName;
                } else {
                    System.out.println(
                            "Введен неверный id, он пустой или содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
                }
            } else {
                try (scan) {
                }
            }
        }
    }

    private static boolean validate(String name) {
        return !name.isEmpty();
    }
}
