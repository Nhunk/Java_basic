package Ontap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class R3_TCPC_Chat {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 2004)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            // Thread to receive messages from the server
            Thread receiveThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        if (serverMessage.equalsIgnoreCase("bye")) {
                            System.out.println("Server disconnected.");
                            break;
                        }
                        System.out.println("Server: " + serverMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            receiveThread.start();

            // Main loop to send messages to the server
            String clientMessage;
            while (true) {
                System.out.print("You: ");
                clientMessage = sc.nextLine();
                out.println(clientMessage);
                if (clientMessage.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            socket.close();
            System.out.println("Disconnected from server.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}