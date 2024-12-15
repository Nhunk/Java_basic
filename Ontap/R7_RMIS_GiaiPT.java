package Ontap;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class R7_RMIS_GiaiPT extends UnicastRemoteObject implements R7_RMI_Interface_GiaiPT{
    protected R7_RMIS_GiaiPT() throws RemoteException {
        super();
    }

    @Override
    public String giaiPT(int a, int b, int c) throws RemoteException{
        double delta = b*b - 4*a*c;
        if(a==0){
            return "Phuong trinh co nghiem kep: " + -b/(2*a);
        }else{
            if(delta < 0){
                return "Phuong trinh vo nghiem";
            }else if(delta == 0){
                return "Phuong trinh co nghiem kep: " + -b/(2*a);
            }else{
                double x1 = (-b + Math.sqrt(delta))/(2*a);
                double x2 = (-b - Math.sqrt(delta))/(2*a);
                return "Phuong trinh co 2 nghiem: x1 = " + x1 + ", x2 = " + x2;
            }
        }
    }
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(2004);
            R7_RMIS_GiaiPT server = new R7_RMIS_GiaiPT();
            java.rmi.Naming.rebind("rmi://localhost:2004/giaiPT", server);
            System.out.println("Server is listening...");
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}
