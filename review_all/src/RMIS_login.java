import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.*;
public class RMIS_login extends UnicastRemoteObject implements RMI_login{
    protected RMIS_login() throws RemoteException{
        super();
    }
    

    @Override
    public String login(String user, String pw) throws RemoteException{
        if(user.equalsIgnoreCase("CS420")&&pw.equalsIgnoreCase("123")){
            return "Success";
        }else
            return "Userv (hoac password) khong dung. Vui long nhap lai!";
    }
    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(2004);
            RMIS_login server = new RMIS_login();
            java.rmi.Naming.rebind("rmi://localhost:2004/login",server);
            System.out.println("Server is running");
        } catch (Exception e) {
        }
    }
}
