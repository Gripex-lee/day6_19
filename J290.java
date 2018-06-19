package day6_19;

/**
 * @author MrBread
 * @date 2017年6月18日
 * @time 下午3:14:05
 * @project_name TestSocket
 * 功能：检测本机端口是否已经被使用用
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;  
import java.net.Socket;
import java.net.UnknownHostException;  

public class J290 {  
	//start--end是所要检测的端口范围
    static int start=800;
    static int end=1024;
    public static void main(String args[]){
        for(int i=start;i<=end;i++){
            System.out.println("查看端口："+i);
            if(isLocalPortUsing(i)){
                System.out.println("端口 "+i+" 被使用");
            }
        }
    }

    /**
     * 测试本机端口是否被使用
     * @param port
     * @return
     */
    public static boolean isLocalPortUsing(int port){  
        boolean flag = true;  
        try {
            //如果该端口还在使用则返回true,否则返回false,127.0.0.1代表本机
            flag = isPortUsing("127.0.0.1", port);  
        } catch (Exception e) {  
        }  
        return flag;  
    }  
    /*** 
     * 测试主机Host的port端口是否被使用
     * @param host 
     * @param port 
     * @throws UnknownHostException  
     */  
    public static boolean isPortUsing(String host,int port) throws UnknownHostException{  
        boolean flag = false;  
        InetAddress Address = InetAddress.getByName(host);  
        try {  
            Socket socket = new Socket(Address,port);  //建立一个Socket连接
            flag = true;  
        } catch (IOException e) {  

        }  
        return flag;  
    }  
}  
