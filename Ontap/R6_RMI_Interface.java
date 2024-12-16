package Ontap;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface R6_RMI_Interface extends Remote{
    public String login(String user, String pass) throws RemoteException;
}
