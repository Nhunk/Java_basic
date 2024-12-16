package Ontap;

import java.util.Scanner;

public class R6_RMIC_Login {
    public static void main(String[] args) {
        try{
            R6_RMI_Interface login = (R6_RMI_Interface) java.rmi.Naming.lookup("rmi://localhost:2004/login");
            Scanner scan = new Scanner(System.in);
            String text;
            int count = 0;
            while(true){
                System.out.println("Nhap User va Password ngan cach boi ';': ");
                text = scan.nextLine();

                if(text.equalsIgnoreCase("exit")){
                    break;
                }
                
                String[] arr = text.split(";");
                String result = login.login(arr[0], arr[1]);
                if(result.equalsIgnoreCase("success")){
                    System.out.println("Ban da truy cap thanh cong");
                    break;
                }else{
                    count++;
                    if(count == 3){
                        System.out.println("Ban da nhap sai 3 lan, ban da het quyen truy cap vao he thong");
                        break;
                    }
                    System.out.println(result);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
