package command_process.commands;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Deque;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;

// Вывести информацию о коллекции.
public class Info implements Command{
    static String date = null;
    static String lastDate;
    static int count = 0;

    @Override
    public String execute(String args, LabWork labWork) {
        String answer = "";

        answer += "Тип коллекции: Двунаправленная очередь";
        answer += "\nДата инициализации: " + date;
        answer += "\nКоличесво элементов: " + CollectionManager.getLabWorks().size();
        answer += "\nДата последнего изменения: " + lastDate;
        answer += "\nКоличество модификаций: " + count;
        answer += "\nId первого элемента: " + getFirstId(CollectionManager.getLabWorks());

        return answer + "\n";

    }

    public static void saveDateOfColl(){
        date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
    public static boolean getDateOfColl(){
        return date != null;
    }

    public static void saveLastDateOfMod(){
        lastDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    public static void counterOfMod(){
        count += 1;
    }

    public static long getFirstId(Deque<LabWork> laba){
        if (!laba.isEmpty()) return laba.getFirst().getId();
        return 0;
    }
}