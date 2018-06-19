package day6_19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend  
{  
  public static void main(String[] args) throws Exception  
  {  
    //1.创建udp服务。通过DatagramSocket对象。  
    DatagramSocket ds = new DatagramSocket(8888);  
  
    //2.确定数据，并封装成数据包。  
    byte[] buf = "这是发送端发送的一条语句！".getBytes();//将一个字符串转化为一个字节数组  
    DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("172.18.34.21"),10000);  
  
    //3.通过socket服务，将已有的数据包发送出去，通过send方法。  
    ds.send(dp);  
  
    //4.关闭资源。  
    ds.close();  
  }  
} 
