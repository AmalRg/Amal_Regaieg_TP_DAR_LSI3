package activite_1_3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void  main(String[] args){
        try {
        	/* Premiere partie */
        	/*
        	// lancement du serveur
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("J'attend le connexion d'un client");
            Socket s = ss.accept();
            System.out.println("Un client est connecté");
            // reception de l'entier
            InputStream is = s.getInputStream();
            int nb = is.read();
            // calcul du produit
            int res = nb * 5;
            // envoie du resultat
            OutputStream os = s.getOutputStream();
            os.write(res);
            // fermeture du socket
            ss.close();
            s.close();
            */
        	
        	/* Deuxieme partie */
        	// lancement du serveur
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("J'attend le connexion d'un client");
            Socket s = ss.accept();
            System.out.println("Un client est connecté");
            // reception de l'entier
            InputStream is = s.getInputStream();
            int nb = is.read();
            // reception de l'operation choisie par le client
            int operation = is.read();
            int rep =0;
            if (operation == 1) {
            	rep = nb + 5;
            } else if (operation == 2) {
            	rep = nb - 5;
            } else if (operation == 3) {
            	rep = nb * 5;
            } else if (operation == 4) {
            	if (nb != 0) {
            		rep = nb / 5;
            	} else {
            		rep =0;
            	}
            }
         // envoie du resultat
            OutputStream os = s.getOutputStream();
            os.write(rep);
            // fermeture du socket
            ss.close();
            s.close();
        	
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}