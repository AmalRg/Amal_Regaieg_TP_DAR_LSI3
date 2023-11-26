package rmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmiService.BanqueImpl;

public class BanqueServer {	// Cette classe représente le serveur RMI pour le service bancaire
 public static void main(String[] args) {

     try {
         // Création du registre RMI sur le port 5050
         LocateRegistry.createRegistry(5050);

         // Création d'une instance de l'implémentation du service bancaire
         BanqueImpl bi = new BanqueImpl();

         // Affichage des informations de l'objet BanqueImpl
         System.out.println(bi.toString());

         // Lire l'objet BanqueImpl au registre RMI avec le nom "BanqueService"
         Naming.rebind("rmi://localhost:5050/BanqueService", bi);

         // Affichage d'un message indiquant que le serveur est en cours d'exécution
         System.out.println("Server en cours d'execution ...");
     } catch (RemoteException | MalformedURLException e) {
         // Lancement une exception RuntimeException avec l'erreur d'origine
         throw new RuntimeException(e);
     }
 }
}
