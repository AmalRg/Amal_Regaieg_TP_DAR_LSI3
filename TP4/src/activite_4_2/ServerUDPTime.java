package activite_4_2;

import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerUDPTime {

	public static final int PORT = 1234;
    public static byte[] buffer = new byte[1024];

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Lancement du serveur ...");
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date currentTime = new Date();
                String dateToSend = date.format(currentTime);
                DatagramPacket toSend = new DatagramPacket(dateToSend.getBytes(), dateToSend.length(),
                        packet.getAddress(), packet.getPort());
                socket.send(toSend);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
