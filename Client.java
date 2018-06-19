package day6_19;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * @author Administrator
 *
 */
public class Client {
    public static void main(String[] args) {
        try {
            //创建一个客户端socket
            Socket socket = new Socket("localhost",8888);
            //向服务器端传递信息
            System.out.println("客户端已经开启----");
            PrintStream ps = new PrintStream(socket.getOutputStream());//将客户端套接字的输出流用printStream包装起来，类似于C语言中的fprintf类型转换
            System.out.print("请输入需要发送到服务器的内容：");
            Scanner sn = new Scanner(System.in);
            String str = sn.nextLine();
            ps.println(str);//把控制台输入的内容送入被printstream类包装的输出流里面  
            ps.close();//关闭输出流包装
            socket.close();//关闭socket套接字，已经传完数据，才能关闭
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
