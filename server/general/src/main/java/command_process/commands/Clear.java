package command_process.commands;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Очистить коллекцию.
public class Clear implements Command{
    @Override
    public String execute(String args, LabWork labwork) {

        CollectionManager.getLabWorks().clear();
        Info.counterOfMod();

        return "Коллекция очищена.";
    }
}