package RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface isTwoDigitInterface {
    boolean isTwoDigitNumber(int n) throws RemoteException;
}
