package accept_connections;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

public class UDPServer {
    public final static int SERVICE_PORT = 54021;

    public static DatagramChannel createChannel() {
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(SERVICE_PORT));
            return channel;
        } catch (IOException e) {
            System.out.println("Ошибка создания канала: " + e.getMessage());
            return null;
        }
    }
}
