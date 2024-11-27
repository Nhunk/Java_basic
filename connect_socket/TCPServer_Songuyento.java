package connect_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer_Songuyento {
    public static boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if( num % i == 0 ) {
                return false;
            }
        }
        return num > 2;
    }
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(9876);
            System.out.println("Server is listening on port 9876");

            while (true) {
                try (Socket connectionSocket = serverSocket.accept()){
                    BufferedReader input = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    PrintWriter output = new PrintWriter(connectionSocket.getOutputStream(), true);

                    String sentence;
                    while((sentence = input.readLine())!=null){
                    if (sentence.equalsIgnoreCase("stop")) {
                        break; 
                    }
                    String[] numbers = sentence.split(";");
                    String primeNumbers = "";
                    for (String number : numbers){
                        if(isPrime(Integer.parseInt(number))) {
                            primeNumbers += number + "; ";
                        }
                    }
                    output.println(primeNumbers.length() > 0 ? primeNumbers : null);
                }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
