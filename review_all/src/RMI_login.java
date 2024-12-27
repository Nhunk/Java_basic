import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RMI_login extends Remote{
    public String login(String user, String pw) throws RemoteException;
}
