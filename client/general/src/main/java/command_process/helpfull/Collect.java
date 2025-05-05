package command_process.helpfull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Collect implements Validation {
    private static long counter = Long
            .parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS00")));
    private final long id;

    public Collect() {
        this.id = ++counter;
    }

    public long takeId() {
        return id;
    }

    public void printId() {
        System.out.println(counter);
    }
}
