package TCP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class A1_TCPS_Boi {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9876);
            System.out.println("Server is listening on port 9876");
            while (true) {
                try (Socket connectionSocket = serverSocket.accept(); //Lắng nghe client
                     BufferedReader input = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                     PrintWriter output = new PrintWriter(connectionSocket.getOutputStream(), true)) {

                    String sentences;
                    while ((sentences = input.readLine()) != null) {
                        if (sentences.equalsIgnoreCase("stop")) {
                            break;
                        }
                        List<Integer> multiplesOf5 = new ArrayList<>();
                        List<Integer> multiplesOf6 = new ArrayList<>();
                        List<Integer> multiplesOf3 = new ArrayList<>();
                        for (String numStr : sentences.split(";")) {
                            try {
                                int num = Integer.parseInt(numStr.trim());
                                if (num % 5 == 0) multiplesOf5.add(num);
                                if (num % 6 == 0) multiplesOf6.add(num);
                                if (num % 3 == 0) multiplesOf3.add(num);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number: " + numStr);
                            }
                        }
                        output.println("Boi so cua 5 la: " + multiplesOf5);
                        output.println("Boi so cua 6 la: " + multiplesOf6);
                        output.println("Boi so cua 3 la: " + multiplesOf3);
                    }
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}