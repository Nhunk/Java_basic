package Ontap;
 import java.rmi.Remote;
 import java.rmi.RemoteException;
public interface R2_RMI_interface extends Remote {
    public int tinhTong(int a, int b) throws RemoteException;
    public int tinhHieu(int c, int d) throws RemoteException;
    
}
