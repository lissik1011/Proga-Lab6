package command_process.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import command_process.collection_manager.CollectionManager;
import command_process.data.LabWork;
import de.siegmar.fastcsv.writer.CsvWriter;
import de.siegmar.fastcsv.writer.LineDelimiter;
import de.siegmar.fastcsv.writer.QuoteStrategies;

public class Output {

    public static void output(String file_name) {
        File file = new File(file_name);

        try (FileWriter writer = new FileWriter(file);
                CsvWriter csv = CsvWriter.builder().fieldSeparator(',').quoteCharacter('"')
                        .quoteStrategy(QuoteStrategies.ALWAYS).commentCharacter('#')
                        .lineDelimiter(LineDelimiter.LF).build(writer)) {

            csv.writeRecord("id", "name", "coordinates.x", "coordinates.y", "creationDate",
                    "minimalPoint", "difficulty", "author.name", "author.weight",
                    "author.passportId", "author.location.x", "author.location.y", "author.location.name");

            for (LabWork labWork : CollectionManager.getLabWorks()) {

                csv.writeRecord(
                        String.valueOf(labWork.getId()),
                        labWork.getName(),
                        String.valueOf(labWork.getCoordinates().getX()),
                        String.valueOf(labWork.getCoordinates().getY()),
                        labWork.getCreationDate().toString(),
                        String.valueOf(labWork.getMinimalPoint()),
                        labWork.getDifficulty().toString(),

                        labWork.getAuthor() != null ? labWork.getAuthor().getName() : "",
                        labWork.getAuthor() != null ? String.valueOf(labWork.getAuthor().getWeight()) : "",
                        labWork.getAuthor() != null ? labWork.getAuthor().getPassportID() : "",
                        labWork.getAuthor() != null ? String.valueOf(labWork.getAuthor().getLocation().getX()) : "",
                        labWork.getAuthor() != null ? String.valueOf(labWork.getAuthor().getLocation().getY()) : "",
                        labWork.getAuthor() != null ? labWork.getAuthor().getLocation().getName() : "");
            }
        } catch (IOException e) {
            System.out.println("Неверный формат файла.");
        }
    }
}

// int id = scanner.nextInt();
// String name = scanner.next();
// int coordinates_x = scanner.nextInt();
// float coordinates_y = scanner.nextFloat();
// int minimalPoint = scanner.nextInt();
// String difficulty = scanner.next();
// String author_name = scanner.next();
// float author_weight = scanner.nextFloat();
// String author_passportId = scanner.next();
// float author_location_x = scanner.nextFloat();
// double author_location_y = scanner.nextDouble();
// String author_location_name = scanner.next();
