package activite_1_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main (String[] args) throws IOException{
        // creation du serveur socket
		ServerSocket ss = new ServerSocket(1234);
        System.out.println("Je suis un server en attente la connexion d'un client");
        
        // acceptation du requete venant du client
        Socket s = ss.accept();
        System.out.println("un client est connecté");

        // Fermeture du socket
        s.close();
        ss.close();
    }

}
