package Ontap;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface R7_RMI_Interface_GiaiPT extends Remote{
    public String giaiPT(int a, int b, int c) throws RemoteException;
}
