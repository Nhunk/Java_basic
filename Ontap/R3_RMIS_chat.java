package Ontap;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class R3_RMIS_Chat extends UnicastRemoteObject implements R3_RMI_interface {
    private String message = "";

    protected R3_RMIS_Chat() throws RemoteException {
        super();
    }

    @Override
    public synchronized void sendMessage(String message) throws RemoteException {
        this.message = message;
        notifyAll();
    }

    @Override
    public synchronized String receiveMessage() throws RemoteException {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }

    public static void main(String[] args) {
        try {
            R3_RMIS_Chat server = new R3_RMIS_Chat();
            Naming.rebind("rmi://localhost:12345/chat", server);
            System.out.println("Server is running...");

            Scanner sc = new Scanner(System.in);
            String serverMessage;
            while (true) {
                System.out.print("You: ");
                serverMessage = sc.nextLine();
                server.sendMessage(serverMessage);
                if (serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Ending chat.");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}