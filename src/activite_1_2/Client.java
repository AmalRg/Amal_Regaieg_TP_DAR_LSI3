package activite_1_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		System.out.println("Je suis un client");
		try {
			// etablir la connection
			Socket s = new Socket("localhost",1234);
			System.out.println("Je suis un connecte");
			// lecture de l'entier
			Scanner Scanner = new Scanner(System.in);
			System.out.println("Donner un nombre: ");
			int nb = Scanner.nextInt();
			// envoie de l'entier vers le serveur
			OutputStream os = s.getOutputStream();
			os.write(nb);
			// reception du resultat
			InputStream is = s.getInputStream();
			int rep = is.read();
			// affichage du resultat
			System.out.println("J'ai recu le resultat : " + rep);
			// fermer le socket
			s.close();
		} catch (IOException e)
			{
				e.printStackTrace();
			}
	}

}
