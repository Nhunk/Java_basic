package Ontap;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class R3_TCPS_Chat {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is running. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String clientMessage, serverMessage;

            while (true) {

                clientMessage = in.readLine();
                System.out.println("Client: " + clientMessage);
                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                System.out.print("You: ");
                serverMessage = sc.nextLine();
                out.writeBytes(serverMessage);
                if (serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Ending chat.");
                    break;
                }
            }
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}