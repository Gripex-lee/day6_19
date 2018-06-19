package day6_19;

import java.io.File;
import java.lang.reflect.Constructor;

public class J303 {
	 public static void main(String[] args){  
	        try {  
	            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);  
	            System.out.println("Create File Object with reflection.");  
	  
	            File file = constructor.newInstance("D:\\test\\MyFile.txt");  
	            System.out.println("Use File Object to create MyFile.txt in D:\\.");  
	            file.createNewFile();
	            System.out.println("File is create?\n"+file.exists());  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
}
