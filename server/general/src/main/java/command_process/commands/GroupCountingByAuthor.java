package command_process.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Сгруппировать элементы коллекции по значению поля author, вывести количество элементов в каждой группе.
public class GroupCountingByAuthor implements Command{
    static Map<String, Integer> authorName = new HashMap<>();

    @Override
    public String execute(String args, LabWork labWork) {
        int nullCounter = 0;
        String answer = "";
        if (!CollectionManager.getLabWorks().isEmpty()) {        
            for (LabWork lab : CollectionManager.getLabWorks()){
                if (lab.getAuthor() != null){
                    Integer authorCount = authorName.get(lab.getAuthor().getName());
                    authorName.put(lab.getAuthor().getName(), authorCount + 1);
                } else {
                    nullCounter += 1;
                }
            }

            Set<String> keys = authorName.keySet();
            for (String key : keys){
                answer += key + ": " + authorName.get(key) + "\n";
                authorName.put(key, 0);
            }

            return answer + "Кол-во лабораторных работ без автора: " + nullCounter;
        } else {
            return "Коллекция пуста.";
        }
    }

    public static void addAName(String name){
        authorName.put(name, 0);
    }
}
