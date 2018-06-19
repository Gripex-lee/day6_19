package day6_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author Administrator
 *
 */
public class Server {

    public static void main(String[] args) throws IOException {
        //创建一个服务器端socket，指定绑定的端口号，并监听此端口
        ServerSocket serverSocket = new ServerSocket(8888);
        //调用accept()方法开始监听，等待客户端的连接
        System.out.println("服务器启动，等待客户端连接");
        Socket socket = serverSocket.accept();
        //获取输入流，并读取客户端信息
        InputStream inp = socket.getInputStream();
        //把字节流转换成字符流
        InputStreamReader isr = new InputStreamReader(inp);
        //为字符流增加缓冲区
        BufferedReader bfr = new BufferedReader(isr);
        String info = null;
        while((info=bfr.readLine())!=null){//循环读取数据
            System.out.println("客户端输入信息："+info);
            System.out.println("上传成功");
        }
        bfr.close();
        isr.close();
        inp.close();
        socket.close();
        serverSocket.close();
        
    }
    
}
