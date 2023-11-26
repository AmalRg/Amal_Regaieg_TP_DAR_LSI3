package activite_4_2;

import java.net.*;

public class ClientUDPTime {

	public static final int PORT = 1234;
    public static byte[] buffer = new byte[1024];

    public static void main(String[] args) throws Exception {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] requestData = new byte[1024];

            DatagramPacket data = new DatagramPacket(requestData, requestData.length,
                    InetAddress.getByName("localhost"), PORT);
            socket.send(data);
            DatagramPacket recData = new DatagramPacket(buffer, buffer.length);
            socket.receive(recData);
            System.out.println("Date et heure founises par le server: " + 
            			new String(recData.getData(), 0, recData.getLength()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
