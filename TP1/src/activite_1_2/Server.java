package activite_1_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        
        // rception de l'entier
        InputStream is = s.getInputStream();
        int nb = is.read();
        
        // calcul du produit
        int res = nb * 5;
        
        // envoie du resulat
        OutputStream os = s.getOutputStream();
        os.write(res);

        // Fermeture du socket
        s.close();
        ss.close();
    }

}
