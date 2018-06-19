package day6_19;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class J296_Client {
	public static void main(String[] args) {
        try {
            //创建一个客户端socket
            Socket socket = new Socket("localhost",8888);
            //向服务器端传递信息
            System.out.println("客户端启动并向服务端传递数字：110");
            PrintStream ps = new PrintStream(socket.getOutputStream());
            int x = 110;
            ps.println(x);//把控制台输入的内容送入被printstream类包装的输出流里面  
            ps.close();//关闭输出流包装
            socket.close();//关闭socket套接字，已经传完数据，才能关闭
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
