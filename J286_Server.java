package day6_19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class J286_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(10008);
		Socket s=ss.accept();
		BufferedReader bufIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter bufout=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String line=null;
		while((line=bufIn.readLine())!=null){
		bufout.write(line.toUpperCase());
		bufout.newLine();
		bufout.flush();
		}
		s.close();
		ss.close();
		}
}
