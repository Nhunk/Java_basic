package Ontap;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface R3_RMI_interface extends Remote{
    public String sendMessage(String msg) throws RemoteException;
    public String receiveMessage() throws RemoteException;
}
