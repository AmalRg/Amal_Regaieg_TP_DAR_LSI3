package activite_1_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			// lancement du serveur
			ServerSocket serverSocket = new ServerSocket(1234);
			System.out.println("Je suis le serveur en attente la connexion d'un client");
			
			// acceptation de la connexion
			Socket s = serverSocket.accept();
			System.out.println("Un client est connecté");
			
			// reception de l'entier
			InputStream is = s.getInputStream();
			int nb = is.read();
			
			// calcul du produit
			int rep = nb * 5;
			
			//envoie du resultat
			OutputStream os = s.getOutputStream();
			os.write(rep);
			
			// fermeture du socket
			s.close();
			serverSocket.close();
			
		} catch (IOException e)
			{
				e.printStackTrace();
			}
	}
}
