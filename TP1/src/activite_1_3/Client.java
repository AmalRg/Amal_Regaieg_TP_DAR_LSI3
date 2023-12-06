package activite_1_3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try
        {
        	/** Premiere partie**/
        	/**
        	// Adresse IP du serveur distant
            InetAddress IA = InetAddress.getByName("192.168.1.14");
            // Adresse IP du serveur et du port
            InetSocketAddress ISA = new InetSocketAddress(IA,1234);
            // Etatblirr la connexion
            Socket s = new Socket();
            s.connect(ISA);
            System.out.println("Je suis un client connecté ..");
            // Lecture de l'entier
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer un entier: ");
            int nb = scanner.nextInt();
            // Envoie de l'entier vers le serveur
            OutputStream os = s.getOutputStream();
            os.write(nb);
            // Reception du resultat
            InputStream is = s.getInputStream();
            int rep = is.read();
            // Affichage du resultat
            System.out.println("J'ai recu le resultat" + rep);
            // Fermeture du socket
            s.close();*/
        	
        	/** Deuxieme partie**/
        	
        	// Adresse IP du serveur distant
            InetAddress IA = InetAddress.getByName("192.168.1.0");
            // Adresse IP du serveur et du port
            InetSocketAddress ISA = new InetSocketAddress(IA,1234);
            // Etatblirr la connexion
            Socket s = new Socket();
            s.connect(ISA);
            System.out.println("Je suis un client connecté ..");
            // Lecture de l'entier
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer un entier: ");
            int nb = scanner.nextInt();
            // Choix de l'operation
            System.out.println("Choisissez l'operation :");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            int operation = scanner.nextInt();
            // Envoie de l'entier et de l'operation vers le serveur
            OutputStream os = s.getOutputStream();
            os.write(nb);
            os.write(operation);
            // Reception du resultat
            InputStream is = s.getInputStream();
            int rep = is.read();
            // Affichage du resultat
            System.out.println("Le resultat est : " + rep);
            // Fermeture du socket
            s.close();
        	
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}