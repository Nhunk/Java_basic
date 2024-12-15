package Ontap;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface R1_RMI_Interface_TongSoNguyen extends Remote{
    public int tinhTong(int n) throws RemoteException;
}
