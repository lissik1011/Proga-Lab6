package command_process.commands;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Обновить элемент по id
public class Update implements Command{
    @Override
    public String execute(String args, LabWork labWork) {

        try {
            long id = Long.parseLong(args);
            LabWork lab = CollectionManager.findLabWorkById(id);
            if (lab != null){
                CollectionManager.getLabWorks().remove(lab);     
                addLab(labWork);   
                return "Элемент обновлен.";
            } else {
                addLab(labWork);
                return "Лабораторная работа с заданный id была удалена. Элемент был добавлен в коллекцию";
            }
        } catch (NumberFormatException e) {
            return "Введен неверный id работы.";
        }
    }

    private void addLab(LabWork labWork){
        CollectionManager.getLabWorks().add(labWork);

        if (labWork.getAuthor() != null) GroupCountingByAuthor.addAName(labWork.getAuthor().getName());
        CollectionManager.addIdInSet(labWork.getId());
        CollectionManager.sort();
        Info.saveLastDateOfMod();
        Info.counterOfMod();
        if (!Info.getDateOfColl()) Info.saveDateOfColl();
    }
}
