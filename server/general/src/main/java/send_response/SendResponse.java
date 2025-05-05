package send_response;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class SendResponse {

    public static void send(DatagramChannel channel, SocketAddress clientAddress, byte[] data) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        channel.send(buffer, clientAddress);
    }
}




    // public void sendResponce(DatagramSocket serverSocket, DatagramPacket inputPacket, byte[] sendingData){
    //     try (serverSocket) {
    //         try {
    //             InetAddress senderAddress = inputPacket.getAddress();
    //             int senderPort = inputPacket.getPort();
                
    //             DatagramPacket outputPacket = new DatagramPacket(sendingData, sendingData.length, senderAddress,senderPort);
    //             serverSocket.send(outputPacket);
                
    //         } catch (IOException e) {
    //             System.out.println("Ошибка отпраки ответа клиенту.");
    //         }
    //     }
    // }