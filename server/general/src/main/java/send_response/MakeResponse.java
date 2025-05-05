package send_response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MakeResponse {
    public static byte[] response(String string) {

        try (
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(string);
            oos.flush(); 
            return bos.toByteArray();
        } catch (IOException e) {
            System.err.println("Ошибка сериализации: " + e.getMessage());
            return new byte[0]; 
        }
    }
}
