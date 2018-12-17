package guanjian.demo15;

import javax.print.attribute.standard.MediaName;

public class RunThreads  implements Runnable{
public static void main(String[] args) {
	  
	RunThreads threads=new RunThreads();
	Thread one =new Thread(threads);
	Thread two =new Thread(threads);
	one.setName("one Thread");
	two.setName("two Thread");
	
	one.start();
	two.start();
	
}
public void run() {
	for(int i=0;i<25;i++) {
		String name =Thread.currentThread().getName();
		System.out.println(name);
		
	}
	
	
	
	
	
}	
	
	
}
