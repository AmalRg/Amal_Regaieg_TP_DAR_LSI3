package activite_1_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// creation du serveur socket
			Socket socket = new Socket("localhost",1234);
			System.out.println("Je suis un client pas encore connecte");
			
			// acceptation de la connexion
			Socket s = socket;
			System.out.println("Je suis un client connecte");
			
			// fermer le socket
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
		} catch (IOException e)
			{
				e.printStackTrace();
			}
	}

}
