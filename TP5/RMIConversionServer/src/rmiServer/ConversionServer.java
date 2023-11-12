package rmiServer;

import rmiService.ConversionImpl;	// Importation de la classe d'implémentation du service distant
import java.net.MalformedURLException;
import java.rmi.Naming;		 // Importation de la classe Naming pour la liaison RMI
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;	// Importation de la classe LocateRegistry pour la création du registre RMI

 public class ConversionServer {

	public static void main(String[] args) {
		 try {	
			 	// Creation du registre locale sur le port 1099
	            LocateRegistry.createRegistry(1099);
	            //instantiation de la methode ConversionImpl implimentée par l'inerface Iconversion 
	            ConversionImpl od = new ConversionImpl();
	            //Affichage de l'objet distant 
	            System.out.println(od.toString());
	            //Liaison de l'objet distant et son no dans le Registre RMI 
	            Naming.rebind("rmi://localhost:1099/ConversionObject",od);
	        } catch (RemoteException | MalformedURLException e) {
	            throw new RuntimeException(e);// Exception en cas d'erreurs 
	        }
	}

}