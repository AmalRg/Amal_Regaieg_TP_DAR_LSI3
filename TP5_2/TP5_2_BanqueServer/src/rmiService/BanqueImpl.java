package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {
	// Stocke les comptes bancaires sous forme d'une liste
	private List<Compte> comptes;

	// Constructeur de la classe
	public BanqueImpl() throws RemoteException {
		// Initialise la liste des comptes lors de la création de l'objet "BanqueImpl"
		comptes = new ArrayList<>();
	}
	// Implémentation de la méthode de création de compte
	@Override
	public String creerCompte(Compte c) throws RemoteException {
		comptes.add(c);
		return c + " a été ajouté avec succès.";
	}
	// Implémentation de la méthode pour obtenir les informations d'un compte à partir d'un code
	@Override
	public String getInfoCompte(int code) throws RemoteException {
		for (Compte compte : comptes) {
			// Vérifier si le code du compte correspond à celui recherché
			if (compte.getCode() == code) {
				// Retourne les informations du compte formatées
				return "Code: " + compte.getCode() + "\nSolde: " + compte.getSolde() + 
						"\nDate de création: " + compte.getDateCreation();
			}
		}
		// Si le compte n'existe pas
		return "Le compte n'existe pas.";
	}
}