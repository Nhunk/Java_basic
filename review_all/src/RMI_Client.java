import java.util.Scanner;

public class RMI_Client {
    public static void main(String[] args) {
        
    
    try{
        RMI_interface server = (RMI_interface) java.rmi.Naming.lookup("rmi://localhost:2004/TinhGiaTri");
        Scanner scan = new Scanner(System.in);
        String text;
        while(true){
            System.out.println("Nhap 2 so nguyen ngan cach boi dau cach: ");
            text = scan.nextLine();
            if(text.equalsIgnoreCase("exit")){
                break;
            }
            String[] arr = text.split(";");
            int result = server.tinhTong(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]))+server.tinhHieu(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            System.out.println("Tong 2 so la: " + result);
        }
    
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
