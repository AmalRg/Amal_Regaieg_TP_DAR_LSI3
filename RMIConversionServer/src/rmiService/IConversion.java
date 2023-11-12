package rmiService;

import java.rmi.Remote; // Importation de l'interface Remote de Java RMI

import java.rmi.RemoteException; // Importation de la classe RemoteException de Java RMI

//Interface définissant les méthodes qui peuvent être invoquées à distance
public interface IConversion extends Remote {
	// Méthode de conversion de montant, peut être invoquée à distance
    double convertirMontant(double mt) throws RemoteException;

}