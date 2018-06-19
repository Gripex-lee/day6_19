package day6_19;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class J288 {
	public static void main(String[] args) {  
        try {  
            InetAddress inetAddress = InetAddress.getLocalHost();  
            System.out.println("本机IP:"  + inetAddress.getHostAddress().toString());  
            System.out.println("本机名称:" + inetAddress.getHostName().toString());  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
    } 
}
