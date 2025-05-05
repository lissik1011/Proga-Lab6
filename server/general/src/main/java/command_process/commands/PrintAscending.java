package command_process.commands;

import java.util.stream.Collectors;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Вывести элементы коллекции в порядке возрастания.
public class PrintAscending implements Command{
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
