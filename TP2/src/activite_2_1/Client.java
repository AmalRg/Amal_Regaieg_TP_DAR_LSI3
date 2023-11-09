package activite_2_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        System.out.println("Je suis un client");
        try {
            // Establishing connection
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Je suis un client connecte");

            // Reading the operation from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Donner la 1er operande: ");
            int operand1 = scanner.nextInt();
            System.out.print("Donner un operateur (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            System.out.print("Donner la 2er operande: ");
            int operand2 = scanner.nextInt();

            // Sending the operation to the server
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(operand1);
            dos.writeChar(operator);
            dos.writeInt(operand2); 

            // Receiving the result from the server
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            int result = dis.readInt();

            // Displaying the result
            System.out.println("Resultat recu du serveur " + result);

            // Closing the socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}