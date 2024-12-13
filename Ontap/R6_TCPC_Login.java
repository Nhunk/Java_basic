/*Để truy cập vào hệ thống, Client phải nhập User và Password của mình và gởi cho Server xác thực.  
Quá trình xác thực trên Server diễn ra như sau :
-	Nếu Client nhập User (hoặc Password) không đúng, 
Server trả về cho Client thông báo “ User (hoặc Password) của bạn không đúng, yêu cầu nhập lại”.  
-	Nếu sau 3 lần đăng nhập liên tiếp vẫn không đúng, 
Server trả về cho Client thông báo “ Bạn đã nhập sai 3 lần, bạn đã hết quyền truy cập vào hệ thống. “ 
Hệ thống đóng kết nối.
-	Nếu Client nhập User và Password đúng, 
Server trả về cho Client thông báo “Bạn đã truy cập thành công “.
Biết rằng, User và Password ở Server được mặc định là : 
User =”CS420”, Password =”123”
 */
package Ontap;

public class R6_TCPC_Login {
    
}
