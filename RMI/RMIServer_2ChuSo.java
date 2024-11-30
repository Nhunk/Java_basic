package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer_2ChuSo extends UnicastRemoteObject implements isTwoDigitInterface{
    protected RMIServer_2ChuSo() throws RemoteException{
        super();
    }
    @Override
    public boolean isTwoDigitNumber(int n) throws RemoteException {
        return (n >= 10 && n <= 99);
    }
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            RMIServer_2ChuSo server = new RMIServer_2ChuSo();
            Naming.bind("isTwoDigitService", server);
            System.out.println("Server san sang.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
