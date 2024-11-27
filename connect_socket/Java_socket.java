package connect_socket;
public class Java_socket {}
    
//241124
// java.net.Socket được đưa vào hai tham số hostname và portnumber(lấy khi server khởi tạo)
// Một client kết nối nhiều server => port để kết nối với server mong muốn
// Inputstream getinputstream(out) gửi dữ liệu đi và nhận dữ liệu về
// Có TH bị bung lỗi. vd: nhập 3 số=> check lenght=>nhập đúng, sai thì báo lỗi
// void close() throws IOException : đóng socket giải phóng kênh ảo và xóa kết nối giữa client và server
// client nhập nhiều=>server xử lý nhiều=> dùng vòng lặp cả hai bên
// InetAddress getInetAddress: lấy địa chỉ của máy tính từ xa => UDP

//Chạy server trước => đăng kí port
//phục vụ tuần tự: Tạo->nghe->kết nối->nhận xử lý và gửi lạ(bước xử lý quan trọng vì nhờ nó mới có kết quả trả về)
//song song(phòng chat qua server)- đa luồng
//Cổng (port):	là 1 số 16 bit
//Từ 0 – 1023: cổng hệ thống
//Từ 1024 – 49151: cổng phải đăng ký (registered port)
//Từ 49152 – 65535: cổng dùng riêng (private port).
//Một số cổng thông dụng

    
    
