import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}

    public static void main(String[] args){
        try{
            Registry registry = LocateRegistry.getRegistry(1099);
            Ianimal stub = (Ianimal) registry.lookup("chien1");
            IdossierSuivi stub2 = (IdossierSuivi) registry.lookup("dossier_rex");
            String dossier_rex = stub2.toString();
            System.out.println(stub.getDossierSuivi());
        }catch(Exception e){
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}