package command_process.collection_manager;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import command_process.data.LabWork;

public class CollectionManager {

    public static Deque<LabWork> labWorks = new ArrayDeque<>();
    public static TreeSet<Long> idSet = new TreeSet<>();

    public static void sort() {
        Comparator<LabWork> byCoordinates = Comparator
            .comparingDouble((LabWork lw) -> lw.getCoordinates().getX())
            .thenComparingDouble(lw -> lw.getCoordinates().getY());

        List<LabWork> labs = labWorks.stream().sorted(byCoordinates)
        .collect(Collectors.toList());

        labWorks.clear();
        labWorks.addAll(labs);
    }

    public static Deque<LabWork> getLabWorks(){
        return labWorks;
    }
    public static TreeSet<Long> getIdSet(){
        return idSet;
    }
    public static void addIdInSet(long id){
        idSet.add(id);
    }
    public static void removeId(long id){
        idSet.remove(id);
    }
    public static LabWork findLabWorkById(long id) {
        return labWorks.stream()
            .filter(lab -> lab.getId() == id)
            .findFirst()
            .orElse(null);
    }
    public static boolean findId(long id){
        return idSet.contains(id);
    }
}
