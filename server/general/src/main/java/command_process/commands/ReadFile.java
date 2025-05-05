package command_process.commands;

import java.nio.file.Path;
import java.nio.file.Paths;

import command_process.data.LabWork;
import command_process.input.Input;
import command_process.input.TakeCsv;

public class ReadFile implements Command {
    @Override
    public String execute(String args, LabWork labWork) {
        Path file = Paths.get(args);
        String answer = Input.input(TakeCsv.takeCsv(file));
        if (answer.isEmpty()) {
            Exit.setFileName("", true);
            return "Объекты добавлены в коллекцию.";
        } 
        else return answer;
    }
}
