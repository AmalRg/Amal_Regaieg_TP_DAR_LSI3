package activite_1_1;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main (String[] args) throws IOException{
        // creation du serveur socket
    	Socket socket = new Socket("localhost",1234);
    	System.out.println("Je suis un client pas encore connecté");
    	
    	// acceptation du requete venant du client
        Socket s = socket;
        System.out.println("Je suis un client connecté");

        // fermeture du socket
        s.close();
    }

}
