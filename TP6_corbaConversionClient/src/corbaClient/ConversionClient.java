package corbaClient;
import CorbaConversion.IConversionRemote;
import CorbaConversion.IConversionRemoteHelper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class ConversionClient {
    public static void main(String[] args) {
        try {
            // Instanciation du context
            Context ctx = new InitialContext();
            // Recherche l'objet distant portant le nom "00" dans le contexte Object
            Object ref = ctx.lookup("00");
            // faire référence à l'objet distant à l'interface CORBA appropriée
            IConversionRemote stub = IConversionRemoteHelper.narrow((org.omg.CORBA.Object) ref);
            // conversion et affichage des résultas
            System.out.println(stub.ConversionMontant(1000.000));
            System.out.println(stub.ConversionMontant(50.000));
        } catch (NamingException e) { throw new RuntimeException(e);}
    }

}
