package command_process.commands;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Вывести первый элемент коллекции.
public class Head implements Command{
    @Override
    public String execute(String args, LabWork labWork) {

        if (CollectionManager.getLabWorks().peek() != null) {
            return CollectionManager.getLabWorks().peek().toString();
        } else {
            return "Коллекция пуста.";
        }
    }
}