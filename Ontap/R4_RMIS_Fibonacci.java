package Ontap;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class R4_RMIS_Fibonacci extends UnicastRemoteObject implements R4_RMI_Interface {
    protected R4_RMIS_Fibonacci() throws RemoteException {
        super();
    }

    @Override
    public int fibonacci(int a, int b, int k, int p) throws RemoteException {
        int[] fibo = new int[k];
        fibo[0] = a;
        fibo[1] = b;
        for (int i = 2; i < k; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        int result = -1;
        for (int i = 0; i < k; i++) {
            if (fibo[i] == p) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(2005);
            R4_RMIS_Fibonacci server = new R4_RMIS_Fibonacci();
            java.rmi.Naming.bind("rmi://localhost:2005/fibonacciService", server);
            System.out.println("Server san sang.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
