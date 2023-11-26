package activite_2_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) {
        try {
            // Server setup
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis le serveur en attente la connexion d'un client...");

            // Accepting a connection 
            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté");

            // Receiving the operation from the client
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            int operand1 = dis.readInt();
            char operator = dis.readChar();
            int operand2 = dis.readInt();

            // Performing the calculation
            int result = performCalculation(operand1, operator, operand2);

            // Sending the result back to the client
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            dos.writeInt(result);

            // Closing the socket
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int performCalculation(int operand1, char operator, int operand2) {
        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            default:
                System.out.println("Operateur invalide !");
        }
        return result;
    }
}