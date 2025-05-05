package read_queries;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MakeRequest {

    public static byte[] request(Object object) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();

            return byteArrayOutputStream.toByteArray();            
        } catch (IOException e) {
            System.out.println("Ошибка сериализации данных." + e.getMessage());
        }
        return null;
    }

    public static byte[] fileBytes(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            return fileBytes;
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.\nКоллекция пуста.");
        }
        return null;
    }
}
