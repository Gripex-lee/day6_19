package day6_19;

/*
 *  * 线程同步 ：使用同步方法，实现线程同步
 * 同步synchronized方法的对象监视锁为this,当前对象
 * 多个线程使用同一把锁，如果线程安全必需确保:多个线程使用的是同一个this对象(Runnable适用于共享同一对象[如：this]，如果Thread继承就会有问题[推荐使用      Runnable])
 * 所有访问此对象方法的线程都在方法外等待,都会判断同步锁,降低效率,但确保线程安全问题
 * java的每个对象都有一个内置锁,当用synchronized关键字修饰方法时,内置锁会保护整个方法。在调用该方法前,线程需要获得内置锁,否则就处于阻塞状态

*synchronized关键字也可以修饰静态方法,此时如果调用该静态方法,将会锁住整个类
 */
public class J282 {
	public static void main(String[] args) {
		 //实现Runnable：所有Thread多线程线程都共享Runnable(接口对象)  
//      NoSync target =new NoSync();  
        SyncMethod target = new SyncMethod();  
        //创建李琦和他老婆两个线程实现取款(同时)  
        Thread lq = new Thread(target);  
        lq.setName("罗密欧");  
        Thread lqwf = new Thread(target);  
        lqwf.setName("朱丽叶");  
        //调用Thread对象的start()方法,启动线程,执行run()方法(OS)  
        lq.start();  
        lqwf.start();  
	}
}
class BankAccount {  
    //余额  
    private int balance = 800;  
    //查询  
    public int getBalance(){  
        return balance;  
    }
    //取款  
    public void withdraw(int amount){  
        balance = balance - amount;  
    }  
    //存款  
    public void deposit(int amount){  
        balance = balance + amount;  
    }  
}  
class SyncMethod implements Runnable{  
    //所有Thread多线程线程都共享Runnable(接口对象)和account对象  
    private BankAccount account = new BankAccount();  
    @Override  
    public void run() {  
        for(int i = 0; i< 5; i++){           //总共取款5次  
            makeWithdraw(100);          //每次取款100  
            if(account.getBalance() < 0){  
                System.out.println(Thread.currentThread().getName()+"   透支了!");  
            }  
        }  
    }  
  
    /** 
     * makeWithdraw 账户取款 
     * @param amount 取款金额<br /> 
     * 打印log记录取款过程 
     * */  
    private synchronized void makeWithdraw(int amount){  
        if(account.getBalance() >= amount){          //如果余额足够则取款  
            System.out.println(Thread.currentThread().getName()+"   准备取款!");  
            try {  
                Thread.sleep(500);  
            } catch (InterruptedException e) {  
                System.out.println(Thread.currentThread().getName()+"   准备取款,等待0.5s线程中断!"+e.getMessage());  
            }  
            account.withdraw(amount);  
            System.out.println(Thread.currentThread().getName()+"   完成"+amount+"取款!余额为"+account.getBalance());
            }else{          //余额不足则提示  
            	System.out.println(+"余额不足以支付"+Thread.currentThread().getName()+amount+"   的取款,余额为"+account.getBalance());  
        }  
    }  
}  
