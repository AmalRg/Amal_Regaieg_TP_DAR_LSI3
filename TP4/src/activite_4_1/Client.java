package activite_4_1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
	private static final int port = 1235;
    private static byte[] buffer = new byte[1024];

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre nom et prenom :" );
        String username = scanner.nextLine();
        DatagramPacket toSend = new DatagramPacket(username.getBytes(), username.length(),
                InetAddress.getByName("localhost"), port);

        socket.send(toSend);
        DatagramPacket toReceive = new DatagramPacket(buffer, buffer.length);
        socket.receive(toReceive);

        // Afficher le message reçu
        String receivedMessage = new String(toReceive.getData(), 0, toReceive.getLength());
        System.out.println("Message du serveur : " + receivedMessage);

        // Afficher l'adresse et le numéro de port du serveur
        InetAddress serverAddress = toReceive.getAddress();
        int serverPort = toReceive.getPort();
        System.out.println("Adresse du serveur : " + serverAddress);
        System.out.println("Numéro de port du serveur : " + serverPort);

        // Fermer le scanner et le socket
        scanner.close();
        socket.close();
    }
}
