package day6_19;

public class J298 {
	/*获取类的声明*/
    private String getClassStatement(Class c){
        StringBuffer buf = new StringBuffer();
        if(c.getName().equals("java.lang.Object")){
            buf.append("public class Object {");
            return buf.toString();
        } else {
            //得到该类的父类名
            String superName = c.getSuperclass().getName();
            buf.append("public class ").append(c.getName()).append(" extends ").append(superName).append(" {");
            return buf.toString();
        }
    }
    public void getClassMessage(){
        StringBuffer buf = new StringBuffer();
        try {
            Class<?> c = Class.forName("com.test.Main");
            buf.append("/*类的声明*/\n");
            buf.append(getClassStatement(c));
            buf.append("}\n");
            System.out.println(buf.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception{
         new J298().getClassMessage();
    }
}
