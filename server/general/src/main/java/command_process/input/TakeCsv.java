package command_process.input;

import java.io.IOException;
import java.nio.file.Path;

import de.siegmar.fastcsv.reader.CommentStrategy;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;

public class TakeCsv {
    public static CsvReader<NamedCsvRecord> takeCsv(Path file) {
        try {
            return CsvReader.builder()
                    .fieldSeparator(',')
                    .quoteCharacter('"')
                    .commentStrategy(CommentStrategy.SKIP)
                    .commentCharacter('#')
                    .skipEmptyLines(true)
                    .ignoreDifferentFieldCount(false)
                    .acceptCharsAfterQuotes(false)
                    .detectBomHeader(true)
                    .maxBufferSize(16777216)
                    .ofNamedCsvRecord(file);

        } catch (IOException e) {
            System.out.printf("Ошибка чтения файла. Description: " + e.getMessage() + "\n");
        }
        return null;
    }
}
