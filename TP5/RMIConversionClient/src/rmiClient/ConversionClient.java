package rmiClient;

import rmiService.IConversion; // Importation de l'interface distante IConversion

import java.rmi.Naming; // Importation de la classe Naming pour la recherche RMI

public class ConversionClient {
    public static void main(String[] args) {
        try {
        	// Recherche du service distant à l'adresse "rmi://localhost:1099/ConversionObject"
            IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1099/ConversionObject");
            // Casting de l'objet distant au type de l'interface IConversion
            
         // Appel de la méthode distante convertirMontant() avec deux exemples d'arguments
            System.out.println("Monatant 1000.00 en EUR : " + stub.convertirMontant(1000.00));
            System.out.println("Monatant 1500.00 en EUR : " + stub.convertirMontant(1500.00));
        }catch(Exception e){		// Gestion des exceptions : affiche la trace de la pile en cas d'erreur
            e.printStackTrace();
        }
    }
}