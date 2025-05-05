package read_queries;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

class ReadQueries {
    public byte[] readQueries(DatagramSocket serverSocket){
        byte[] receivingDataBuffer = new byte[65000];

        DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
        System.out.println("Ожидание подключения клиента...");
      
        try {
            serverSocket.receive(inputPacket);
            byte[] receivedData = inputPacket.getData();
            return receivedData;   

        } catch (IOException ex) {
            System.out.println("Ошибка получения данных.");
        }
        return null;
    }
}
