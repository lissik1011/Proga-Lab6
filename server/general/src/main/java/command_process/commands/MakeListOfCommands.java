package command_process.commands;

import java.util.HashMap;
import java.util.Set;

public class MakeListOfCommands{
    public static final HashMap<String, Command> listCommands = new HashMap<>();

    public HashMap<String, Command> takeList(){
        return listCommands;
    }

    Set<String> getKeys(){
        return listCommands.keySet();
    }

    public void addRecord(String name, Command command){
        listCommands.put("name", command);
    }

    static {
        listCommands.put("add", new Add());
        listCommands.put("clear", new Clear());
        listCommands.put("exit", new Exit());
        listCommands.put("filter_contains_name", new FilterConteinsName());
        listCommands.put("find_id", new FindId());
        listCommands.put("group_counting_by_author", new GroupCountingByAuthor());
        listCommands.put("head", new Head());
        listCommands.put("help", new Help());
        listCommands.put("history", new History());
        listCommands.put("info", new Info());
        listCommands.put("print_ascending", new PrintAscending());
        listCommands.put("read_file", new ReadFile());
        listCommands.put("remove_by_id", new RemoveById());
        listCommands.put("remove_greater_by_id", new RemoveGreaterById());
        listCommands.put("save", new Save());
        listCommands.put("show", new Show());
        listCommands.put("update_by_id", new Update());
    }
}