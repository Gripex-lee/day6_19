package day6_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class J285{
	public static void main(String[] args) 
    {
        try{
        Socket sk =new Socket("172.18.34.21",38380);
        System.out.println("客户端已经开启----");
        PrintStream ps = new PrintStream(sk.getOutputStream());//将客户端套接字的输出流用printStream包装起来，类似于C语言中的fprintf类型转换
        System.out.print("请输入需要发送到服务器的内容：");
        Scanner sn = new Scanner(System.in);
        String str = sn.nextLine();
        ps.println(str);//把控制台输入的内容送入被printstream类包装的输出流里面  
        ps.close();//关闭输出流包装
        sk.close();//关闭socket套接字，已经传完数据，才能关闭
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class CS_Server 
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(38380);//是一个能够接受其他通信实体请求的类
        System.out.println("服务器正在等待客户端的连接请求----");
        //用一个while循环可以同时响应多个客户端的请求
        while(true){
             Socket sk= ss.accept();//服务器监听对应端口的输入
             ServerThread  st = new ServerThread(sk);//创建一个线程，用线程创建一个套接字
             st.start();
        }
    }
}

//服务器线程类
class ServerThread extends Thread
{
    Socket sk;
    public ServerThread(Socket sk){
    this.sk= sk;
    }
    public void run() {     
        BufferedReader br=null;
        try{
        br  = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        String line = br.readLine();
        System.out.println("来自客户端的数据："+line);
        br.close();
        sk.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}