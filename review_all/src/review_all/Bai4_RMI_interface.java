package review_all;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bai4_RMI_interface extends Remote{
    public int Fibonacci(int a, int b, int k, int p) throws RemoteException;
}
