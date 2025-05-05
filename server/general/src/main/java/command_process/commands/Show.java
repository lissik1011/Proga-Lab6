package command_process.commands;

import java.util.stream.Collectors;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Вывести все элементы коллекции в строковом представлении.
public class Show implements Command {
    @Override
    public String execute(String args, LabWork labWork) {
        
        if (CollectionManager.getLabWorks().isEmpty()){
            return "Коллекция пуста.";
        } else {
            return CollectionManager.getLabWorks().stream()
                .map(LabWork::toString).collect(Collectors.joining());
        }
    }
}
