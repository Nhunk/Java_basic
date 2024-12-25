package review_all;
import java.rmi.*;
public interface Bai5_RMI_Interface extends Remote{
    public boolean isperfectnumber(int n) throws RemoteException;
}
