package connection;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient{
  public final static int SERVICE_PORT = 54021;
  
  public static byte[] sendAndReceive(byte[] sendingData) {
    try (DatagramSocket clientSocket = new DatagramSocket();){

      
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] receivingDataBuffer = new byte[65500];
      
      DatagramPacket sendingPacket = new DatagramPacket(sendingData,sendingData.length,IPAddress, SERVICE_PORT);
      clientSocket.send(sendingPacket);

      DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
      clientSocket.receive(receivingPacket);
      
      byte[] receivedData = receivingPacket.getData();

      return receivedData;
    }
    catch(SocketException e) {
      System.out.println("Нет соединения.");
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println("Ошибка передачи данных.");
    }
    return null;
  }
}
