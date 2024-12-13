package Ontap;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class R2_RMI_Server extends UnicastRemoteObject implements R2_RMI_interface {
    protected R2_RMI_Server() throws RemoteException {
        super();
    }

    @Override
    public int tinhTong(int a, int b) throws RemoteException {
        return 25*(a + b);
    }

    @Override
    public int tinhHieu(int c, int d) throws RemoteException {
        return 6*(c - d);
    }
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(2001);
            R2_RMI_Server server = new R2_RMI_Server();
            Naming.bind("rmi://localhost:2001/tinhTongService", server);
            Naming.bind("rmi://localhost:2001/tinhHieuService", server);
            System.out.println("Server san sang.");	
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
