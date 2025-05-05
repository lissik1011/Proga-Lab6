package command_process.commands;

import command_process.data.LabWork;
import command_process.output.Output;

// Сохранить коллекцию в файл.
public class Save implements Command {
    @Override
    public String execute(String args, LabWork labWork) {
        String file_name = args + ".csv";
        Output.output(file_name);
        String answer = "CSV-файл успешно записан. Название файла: " + file_name;
        System.out.println(answer);
        return answer;
    }
}