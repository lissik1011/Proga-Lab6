package command_process.commands;

import command_process.data.LabWork;
import command_process.output.Output;

// Завершить программу (без сохранения в файл).
public class Exit implements Command{
    static String file_name = "";
    static boolean server_file = false;
    @Override
    public String execute(String args, LabWork labwork) {
        if (server_file && args.isEmpty()) {
            return "Введите название файла";
        } else if (server_file && !args.isEmpty()) {
            Output.output(args);
            System.out.println("CSV-файл успешно записан. Название файла: " + file_name);
            return"Завершение работы программы.";
        } else {
            Output.output(file_name);
            System.out.println("CSV-файл успешно записан. Название файла: " + file_name);
            return"Завершение работы программы.";
        }
    }

    public static void setFileName(String name, boolean server) {
        file_name = name;
        server_file = server;
    }
}