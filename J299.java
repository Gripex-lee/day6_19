package day6_19;

import java.lang.reflect.Constructor;

public class J299 {
	public static void main(String[] args) {
		String s="hello";
		J299.printClassMessage(s);
		J299.printClassFieldMessage(s);
		J299.printConstructMessage(s);
	}
	public static void printClassMessage(Object obj){
	    // 获取对象的类类型
	    Class c = obj.getClass();
	 
	    //获取类的名称
	    System.out.print("类的名称：" + c.getName());
	 
	    //获取的类的方法
	    java.lang.reflect.Method[] methods = c.getMethods();
	    // c.getDeclaredMethods();
	    for (int i = 0; i < methods.length; i++) {
	 
	        // 得到方法名
	        System.out.print("类的方法名：" + methods[i].getName());
	 
	        // 得到方法的返回值类型的类类型
	        Class returnType = methods[i].getReturnType();
	        System.out.print(" " + returnType.getSimpleName() + " (");
	 
	        // 获取参数列表的类型的类类型
	        Class[] paramTypes = methods[i].getParameterTypes();
	        for (int j = 0; j < paramTypes.length; j++) {
	            System.out.print(paramTypes[j].getSimpleName());
	            if (j < paramTypes.length-1){
	                System.out.print(", ");
	            }
	        }
	        System.out.print(")\n");
	    }
	}
/**
 * 打印的成员变量的信息
 *
 * @param obj
 */
	public static void printClassFieldMessage(Object obj) {
	    // 获取对象的类类型
	    Class c = obj.getClass();
	    /*
	     * 成员变量也是对象
	     * java.lang.reflect.Field
	     * Field类封装了关于成员变量的操作
	     * getFields()方法获取的是所有的public的成员变量的信息
	     * getDeclaredFields获取的是该类自己声明的成员变量的信息
	     */
	    java.lang.reflect.Field[] fields = c.getDeclaredFields();
	 
	    for (java.lang.reflect.Field field : fields) {
	 
	        //得到成员变量的类型的类类型
	        Class FiledType = field.getType();
	        String typeName = FiledType.getName();
	        //得到成员变量的名称
	        String fieldName = field.getName();
	        System.out.println(typeName + "  " + fieldName);
	    }
	}
/**
 * 打印对象的构造函数的信息
 *
 * @param obj
 */
	public static void printConstructMessage(Object obj) {
	    // 获取对象的类类型
	    Class c = obj.getClass();
	
	    Constructor[] cs = c.getDeclaredConstructors();
	
	    for (Constructor constructor : cs) {
	        System.out.print(constructor.getName() + "(");
	        //获取构造函数的参数列表--->得到的是参数列表的类类型
	        Class[] paramTypes = constructor.getParameterTypes();
	        for (Class class1 : paramTypes) {
	            System.out.print(class1.getName() + ", ");
	        }
	        System.out.println(")");
	    }
	}
}
