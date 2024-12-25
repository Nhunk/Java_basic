package review_all;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Bai5_RMIS_SoHoanHao extends UnicastRemoteObject implements Bai5_RMI_Interface {

    protected Bai5_RMIS_SoHoanHao() throws RemoteException {
        super();
    }

    @Override
    public boolean isperfectnumber(int n) throws RemoteException {
        int sum = 0;
        for(int i = 0; i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        if(n==sum){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        try {
           LocateRegistry.createRegistry(1099);
           Bai5_RMIS_SoHoanHao server = new Bai5_RMIS_SoHoanHao();
           java.rmi.Naming.bind("Sohoanhao", server);
            System.out.println("Server is running!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
