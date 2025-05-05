package read_queries;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class MakeQueries implements Serializable {

    public static CreateSendableObject answer(byte[] receiveData) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveData))) {
            return (CreateSendableObject) ois.readObject();
        } catch (IOException e) {
            System.out.println("Неверный формат данных.");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Проблема десериализации");
            return null;
        }
    }
}
