package day6_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class J306_Laozhou {
	private Socket s;  
    private BufferedReader br;   
    private PrintWriter out;  
    private boolean flag = true;  
      
    public static void main(String[] args) {  
        new J306_Laozhou().stratUp();  
    }  
  
    private void stratUp() {  
        BufferedReader sbr = null;  
        try {  
            s = new Socket("127.34.23.21", 5858);  
            out = new PrintWriter(s.getOutputStream(), true);  
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));  
            out.println("老周");   
            sbr = new BufferedReader(new InputStreamReader(System.in));  
              
            new Thread(new ClientThread()).start();  
            String str = null;  
            while (flag && (str=sbr.readLine())!=null) {  
                if (!flag) break;
                out.println(str);
            }  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (s != null) s.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            try {  
                if (sbr != null) s.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
    private void receive() {  
        try {  
            String rs = br.readLine();  
            if (rs.equalsIgnoreCase("disconnect")) {  
                flag = false;  
                System.out.println("点击回车退出");  
            }  
            System.out.println(rs);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    private class ClientThread implements Runnable {  
  
        @Override  
        public void run() {  
            while (true) {  
                if (!flag) break;  
                receive();  
            }  
        }  
          
    }
}
