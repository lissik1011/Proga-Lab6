package command_process.commands;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

public class FindId implements Command{
    @Override
    public String execute(String args, LabWork labwork) {
        try {
            long id = Long.parseLong(args);
        return CollectionManager.findId(id)
            ? ""
            : "Лабораторной работы с id = " + args + " нет.";
        } catch (NumberFormatException e) {
            return "Введен неверный id работы.";
        }
    }
}
