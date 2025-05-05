package command_process.commands;

import java.util.stream.Collectors;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Вывести элементы, значение поля name которых содержит заданную подстроку.
public class FilterConteinsName implements Command{    
    @Override
    public String execute(String args, LabWork labwork){

        String result = CollectionManager.getLabWorks().stream()
            .filter(lab -> lab.getName().contains(args))
            .map(LabWork::toString)
            .collect(Collectors.joining("\n"));
        return result.isEmpty() ? "Лабораторные с заданной подстрокой в названии не найдены." : result;
    }
}
