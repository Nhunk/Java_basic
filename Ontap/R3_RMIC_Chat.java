package Ontap;

import java.rmi.Naming;
import java.util.Scanner;

public class R3_RMIC_Chat {
    public static void main(String[] args) {
        try {
            R3_RMI_interface chat = (R3_RMI_interface) Naming.lookup("rmi://localhost:12345/chat");
            Scanner sc = new Scanner(System.in);
            String clientMessage, serverMessage;

            // Thread to receive messages from the server
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        serverMessage = chat.receiveMessage();
                        System.out.println("Server: " + serverMessage);
                        if (serverMessage.equalsIgnoreCase("bye")) {
                            System.out.println("Server disconnected.");
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            receiveThread.start();

            // Main loop to send messages to the server
            while (true) {
                System.out.print("You: ");
                clientMessage = sc.nextLine();
                chat.sendMessage(clientMessage);
                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Ending chat.");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}