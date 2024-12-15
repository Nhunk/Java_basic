package Ontap;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class R5_RMIS_SoHoanThien extends UnicastRemoteObject implements R5_RMI_Interface{
    protected R5_RMIS_SoHoanThien() throws RemoteException {
        super();
    }
     @Override
    public boolean isPerfectNumber(int num) throws RemoteException {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(2004);
            R5_RMIS_SoHoanThien server = new R5_RMIS_SoHoanThien();
            java.rmi.Naming.bind("rmi://localhost:2004/soHoanThienService", server);
            System.out.println("Server san sang.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
