
import java.util.Scanner;


public class RMIC_login {


    public static void main(String args[]) {
        try {
            RMI_login service = (RMI_login) java.rmi.Naming.lookup("rmi://localhost:2004/login");
            Scanner scan = new Scanner(System.in);
            String text;
            int count = 0;
            while(true){
                System.out.println("Nhap user va password ngan cach boi dau ';' hoac 'stop' de ket thuc: ");
                text = scan.nextLine();
                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                String[] s = text.split(";");
                String result = service.login(s[0],s[1]);
                if(result.equalsIgnoreCase("success")){
                    System.out.println("Ban da truy cap thanh cong!");
                    break;
                }else{
                    count++;
                    if(count==3){
                        System.out.println("Het quyen truy cap vao he thong");
                        break;
                    }
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
