package Ontap;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface R5_RMI_Interface extends Remote{
    public boolean isPerfectNumber(int n) throws RemoteException;   
}
