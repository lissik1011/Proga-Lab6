package connection;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class UDPClient{
  public final static int SERVICE_PORT = 54021;
  private final static int TIMEOUT_MS = 5000; // 5 секунд таймаут
  private final static int MAX_RETRIES = 3; // Максимальное количество попыток
  
  public static byte[] sendAndReceive(byte[] sendingData) {
    byte[] receivingDataBuffer = new byte[65500];
    
    for (int attempt = 1; attempt < MAX_RETRIES; attempt++){
        try (DatagramSocket clientSocket = new DatagramSocket();){
          clientSocket.setSoTimeout(TIMEOUT_MS);
          InetAddress IPAddress = InetAddress.getByName("localhost");

          DatagramPacket sendingPacket = new DatagramPacket(sendingData,sendingData.length,IPAddress, SERVICE_PORT);
          clientSocket.send(sendingPacket);
          
          DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
          try {
            clientSocket.receive(receivingPacket);
            byte[] receivedData = receivingPacket.getData();
            return receivedData;
          } catch (SocketTimeoutException e) {
            System.out.println("Таймаут ожидания ответа. Повторная попытка...\n");
            // continue;
          } 
        } catch(SocketException e) {
          System.out.println("Нет соединения.");
          System.out.println(e.getMessage());
          break;
        } catch (IOException e) {
          System.out.println("Ошибка передачи данных.");
          break;
        }
      }
    System.out.println("Сервер не отвечает после " + MAX_RETRIES + " попыток.");
    return null;
  }
}
