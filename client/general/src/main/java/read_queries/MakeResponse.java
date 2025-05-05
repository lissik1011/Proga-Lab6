package read_queries;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MakeResponse {
    public static String answer(byte[] receiveData){
    if (receiveData == null || receiveData.length == 0) {
        return "Ошибка: получены пустые данные";
    }
    try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveData))) {
        Object obj = ois.readObject();
        if (obj instanceof String string) {
            return string;
        }
        return "Ошибка: получен объект типа null";
    } catch (IOException e) {
        return "Ошибка десериализации";
    } catch (ClassNotFoundException e) {
        return "Class not found";
    }
    }
}
