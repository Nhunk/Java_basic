package Ontap;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface R3_RMI_interface extends Remote{
    void sendMessage(String message) throws RemoteException;
    String receiveMessage() throws RemoteException;
}
