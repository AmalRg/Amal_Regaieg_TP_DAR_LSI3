package activite_1_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// creation du serveur socket
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Je suis le serveur en attente la connexion d'un client");
			
			// acceptation de la connexion
			Socket s = ss.accept();
			System.out.println("Un client est connecté");
			
			// fermeture du socket
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
		} catch (IOException e)
			{
				e.printStackTrace();
			}
	}
}