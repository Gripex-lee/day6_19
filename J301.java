package day6_19;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class J301 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {  
        Class<?> clazz = Class.forName("javax.swing.JFrame");  
        Constructor constructor = clazz.getConstructor(String.class);  
        Object obj = constructor.newInstance("测试窗口");  //反射机制
        System.out.println(obj);  
    }
}
