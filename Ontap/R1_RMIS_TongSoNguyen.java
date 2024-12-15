package Ontap;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class R1_RMIS_TongSoNguyen extends UnicastRemoteObject implements R1_RMI_Interface_TongSoNguyen{
    protected R1_RMIS_TongSoNguyen() throws RemoteException {
        super();
    }
    @Override
    public int tinhTong(int n) throws RemoteException {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(2004);
            R1_RMIS_TongSoNguyen server = new R1_RMIS_TongSoNguyen();
            Naming.bind("rmi://localhost:2004/tinhTongService", server);
            System.out.println("Server san sang.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
