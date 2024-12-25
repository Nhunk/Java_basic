package review_all;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Bai4_RMIS_Fibonacci extends UnicastRemoteObject implements Bai4_RMI_interface {
    protected Bai4_RMIS_Fibonacci() throws RemoteException {
        super();
    }

    @Override
    public int Fibonacci(int a, int b, int k, int p) throws RemoteException {
        int[] fib = new int[k];
        fib[0] = a;
        fib[1] = b;
        for (int i = 2; i < k; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int result = -1;
        for (int i = 0; i < k; i++) {
            if (fib[i] == p) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Bai4_RMIS_Fibonacci server = new Bai4_RMIS_Fibonacci();
            java.rmi.Naming.bind("FibonacciService", server);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
