package day6_19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class J286_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket("172.18.34.21",10008);
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufwOut=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		BufferedReader bufrIn=new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line=null;
		while((line=bufr.readLine())!=null){

		if("over".equals(line)){
		break;
		}
		bufwOut.write(line);
		bufwOut.newLine();
		bufwOut.flush();
		String str=bufrIn.readLine();
		System.out.print(str);
		}
		bufr.close();
		s.close();
	}
}
