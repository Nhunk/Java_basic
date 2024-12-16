package Ontap;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class R3_TCPC_Chat {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            String clientMessage, serverMessage;

            while (true) {
                
                System.out.print("You: ");
                clientMessage = sc.nextLine();
                out.println(clientMessage);
                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Ending chat.");
                    break;
                }

                serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);
                if (serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Server disconnected.");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}