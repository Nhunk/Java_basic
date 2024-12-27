package Ontap;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class R3_RMIS_chat extends UnicastRemoteObject implements R3_RMI_interface {
    private static final long serialVersionUID = 1L;
    private String message = "";

    protected R3_RMIS_chat() throws RemoteException {
        super();
    }

    @Override
    public String sendMessage(String msg) throws RemoteException {
        message = msg;
        System.out.println("Client: " + message);
        return message;
    }

    @Override
    public String receiveMessage() throws RemoteException {
        return message;
    }
    public static void main(String[] args) {
        try {
            R3_RMIS_chat chat = new R3_RMIS_chat();
            java.rmi.registry.LocateRegistry.createRegistry(12345);
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(12345);
            registry.rebind("chat", chat);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
