package command_process.commands;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Добавить новый элемент в коллекцию.
public class Add implements Command{
    @Override
    public String execute(String args, LabWork labwork) {

        CollectionManager.getLabWorks().add(labwork);

        if (labwork.getAuthor() != null) GroupCountingByAuthor.addAName(labwork.getAuthor().getName());
        CollectionManager.sort();
        CollectionManager.addIdInSet(labwork.getId());
        Info.saveLastDateOfMod();
        Info.counterOfMod();
        if (!Info.getDateOfColl()) Info.saveDateOfColl();   

        return "Элемент добавлен в коллекцию.";
    }
}