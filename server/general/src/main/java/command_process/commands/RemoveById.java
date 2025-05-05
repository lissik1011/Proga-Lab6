package command_process.commands;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Удалить элемент из коллекции по его id.
public class RemoveById implements Command{
    @Override
    public String execute(String args, LabWork labWork) {
        
        try {
            long id = Long.parseLong(args);
            if (CollectionManager.getLabWorks().isEmpty()) {
                return "Коллекция пуста.";
            } else {
                LabWork lab = CollectionManager.findLabWorkById(id);
                if (lab == null) return "Работы с таким id не существует. REMOVEBYID";
                else {
                    CollectionManager.getLabWorks().remove(lab);
                    CollectionManager.removeId(lab.getId());
                    return "Элемент с id = " + id + " успешно удален.";
                }
            }   
        } catch (NumberFormatException e) {
            return "Введен неверный id работы.";
        }

    }
}
