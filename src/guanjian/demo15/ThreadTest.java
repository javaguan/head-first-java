package guanjian.demo15;

 public class ThreadTest {
	public static void main(String[] args) {
		
	
	Runnable myrunnable=new MyRunnablely();
	Thread thread=new Thread(myrunnable);
	thread.start();
	System.out.println("Ö÷º¯Êý");
	
	
	}
 }
 