package Ontap;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class R6_RMIS_Login extends UnicastRemoteObject implements R6_RMI_Interface {
    public R6_RMIS_Login() throws RemoteException {
        super();
    }

    @Override
    public String login(String user, String pass) throws RemoteException {
        
        if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
            return "success";
        } else {
            return "User hoac Password cua ban khong dung, yeu cau nhap lai";
        }
    }
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(2004);
            R6_RMIS_Login login = new R6_RMIS_Login();
            java.rmi.Naming.rebind("rmi://localhost:2004/login", login);
            System.out.println("Server is listening...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
