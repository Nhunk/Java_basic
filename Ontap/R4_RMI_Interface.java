package Ontap;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface R4_RMI_Interface extends Remote{
    public int fibonacci(int a, int b,int k,int p) throws RemoteException; 
}
