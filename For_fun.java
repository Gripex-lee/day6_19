package day6_19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class For_fun {
	public static void main(String []args)throws Exception  {  
		URL u=new URL("ftp://localhost/a.txt");  
        URLConnection  urlconn=u.openConnection();  
        BufferedReader br=new BufferedReader(new  InputStreamReader(urlconn.getInputStream()));  
        String line;
        while(null!=(line=br.readLine()))  {
             System.out.println(line);  
        }
    }    
}