package rmiService;

import java.rmi.Remote;

import java.rmi.RemoteException;

import metier.Compte;
//Méthode pour créer un compte bancaire à distance
public interface IBanque extends Remote {
	
    // Cette méthode permet de créer un compte bancaire
    String creerCompte(Compte c) throws RemoteException;

    // Cette méthode permet d'obtenir les informations d'un compte en fonction de son code
    String getInfoCompte(int code) throws RemoteException;
}
