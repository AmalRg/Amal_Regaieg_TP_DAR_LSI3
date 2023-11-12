package activite_1_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main (String[] args) throws IOException{
        // creation du serveur socket
    	Socket socket = new Socket("localhost",1234);
    	System.out.println("Je suis un client pas encore connecté");
    	
    	// acceptation du requete venant du client
        Socket s = socket;
        System.out.println("Je suis un client connecté");
        
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        System.out.println("Entrez un nombre : ");
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        os.write(nb);
        int res = is.read();
        System.out.println(res);

        // fermeture du socket
        s.close();
    }

}
