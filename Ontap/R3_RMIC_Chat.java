package Ontap;

public class R3_RMIC_Chat {
    public static void main(String[] args) {
        try {
            R3_RMI_interface chat = (R3_RMI_interface) java.rmi.Naming.lookup("rmi://localhost:12345/chat");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String clientMessage, serverMessage;
            while (true) {
                System.out.print("You: ");
                clientMessage = sc.nextLine();
                chat.sendMessage(clientMessage);
                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Ending chat.");
                    break;
                }
                serverMessage = chat.receiveMessage();
                System.out.println("Client: " + serverMessage);
                if (serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
