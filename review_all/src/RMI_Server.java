import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server extends UnicastRemoteObject implements RMI_interface{
    protected RMI_Server() throws RemoteException{
        super();
    }

    @Override
    public int tinhTong(int a, int b) throws RemoteException {
         return a+b;
    }

    @Override
    public int tinhHieu(int c, int d) throws RemoteException {
return c-d;    }
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(2004);
            RMI_Server server = new RMI_Server();
            Naming.rebind("rmi://localhost:2004/TinhGiaTri", server);
            System.out.println("Server is listening...");
        } catch (Exception e) {
        }
    }
}
