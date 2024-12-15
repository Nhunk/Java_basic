package Ontap;

import java.util.Scanner;

public class R5_RMIC_SoHoanThien {
    public static void main(String[] args) {
        try{
                R5_RMI_Interface sv = (R5_RMI_Interface) java.rmi.Naming.lookup("rmi://localhost:2004/soHoanThienService");
                Scanner scan = new Scanner(System.in);
                String text;
                while(true){
                    System.out.println("Nhap day so cach nhau boi dau ';'");
                    text = scan.nextLine();
                    if(text.equalsIgnoreCase("stop")){
                        break;
                    }
                    try{
                        String[] arr = text.split(";");
                        String result = "";
                        for(int i = 0; i < arr.length; i++){
                            int num = Integer.parseInt(arr[i]);
                            if(sv.isPerfectNumber(num)){
                                result += num + " vi tri trong day so: " + (i + 1) + "\n";
                            }
                        }
                        if(result.isEmpty()){
                            result = "Khong co so hoan thien trong day";
                        }
                        System.out.println(result);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
