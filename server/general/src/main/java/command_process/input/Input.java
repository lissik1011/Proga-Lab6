package command_process.input;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import command_process.collection_manager.CollectionManager;
import command_process.commands.GroupCountingByAuthor;
import command_process.commands.Info;
import command_process.data.Coordinates;
import command_process.data.Difficulty;
import command_process.data.LabWork;
import command_process.data.Location;
import command_process.data.Person;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;

public class Input {

    public static String input(CsvReader<NamedCsvRecord> csv) {
        try {
            LabWork labWork;

            for (NamedCsvRecord rec : csv) {
                try {
                    long id = Long.parseLong(rec.getField("id"));
                    String name = rec.getField("name");
                    int coordinatesX = Integer.parseInt(rec.getField("coordinates.x"));
                    float coordinatesY = Float.parseFloat(rec.getField("coordinates.y"));
                    LocalDateTime creationDate = LocalDateTime.parse(rec.getField("creationDate"));
                    int minimalPoint = Integer.parseInt(rec.getField("minimalPoint"));
                    Difficulty difficulty = Difficulty.valueOf(rec.getField("difficulty"));

                    if (rec.getField("author.name").isEmpty()) {
                        labWork = new LabWork(id, name, new Coordinates(coordinatesX, coordinatesY), creationDate,
                                minimalPoint, difficulty, null);
                    } else {
                        String authorName = rec.getField("author.name");
                        Float authorWeight = Float.valueOf(rec.getField("author.weight"));
                        String authorPassportId = rec.getField("author.passportId");
                        Float authorLocationX = Float.valueOf(rec.getField("author.location.x"));
                        Double authorLocationY = Double.valueOf(rec.getField("author.location.y"));
                        String authorLocationName = rec.getField("author.location.name");

                        labWork = new LabWork(id, name, new Coordinates(coordinatesX, coordinatesY), creationDate,
                                minimalPoint, difficulty,
                                new Person(authorName, authorWeight, authorPassportId,
                                        new Location(authorLocationX, authorLocationY, authorLocationName)));
                    }

                    if (labWork.validate()) {
                        if (!CollectionManager.getIdSet().contains(id)) {
                            labWork.setId(id);
                            CollectionManager.getLabWorks().add(labWork);
                            CollectionManager.getIdSet().add(id);

                            if (labWork.getAuthor() != null) GroupCountingByAuthor.addAName(labWork.getAuthor().getName());
                            CollectionManager.sort();

                        } else {
                            return "Объект с id = " + id
                                    + " уже существует. Запись не добавлена. Имя записи: " + name;
                        }
                    } else {
                        return "Объект с id = " + id + " не был добавлен в коллекцию. Данные не валидные.";
                    }

                } catch (NumberFormatException e) {
                    return "Неверные данные. Объект не добавлен. Id записи: " + rec.getField("id")
                            + ". Ошибка преобразования числа: " + e.getMessage();
                } catch (DateTimeParseException e) {
                    return "Неверные данные. Объект не добавлен. Id записи: " + rec.getField("id")
                            + ". Ошибка преобразования даты: " + e.getMessage();
                } catch (IllegalArgumentException e) {
                    return "Неверные данные. Объект не добавлен. Id записи: " + rec.getField("id")
                            + ". Ошибка преобразования значения в difficulty: " + e.getMessage();
                } catch (Exception e) {
                    return 
                            e.getMessage() + "Неверные данные. Объект не добавлен. Id записи = " + rec.getField("id");
                }
            }
            // Всё успешно добавлено! Нет нужды в комментариях.
            if (!CollectionManager.getLabWorks().isEmpty()) {
                Info.saveDateOfColl();
                return "";

            } else {
                return "Объектов нет.";
            }

        } catch (Exception e) {
            if (!CollectionManager.getLabWorks().isEmpty()) {
                return "Корректные объекты добавлены.";
            }
            return "Ошибка чтения данных. Проверьте их на корректность.";
        }
    }
}
