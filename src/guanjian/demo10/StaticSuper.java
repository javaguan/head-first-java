package guanjian.demo10;

import java.util.Random;

class StaticTexts {
	
	 static{
		
		
		System.out.println("super static block");
	}
	 StaticTexts(){
		 
		 System.out.println("super constructor");
	 }

}
public class StaticSuper extends StaticTexts{
	static int rand;
	
	static {
		rand=(int)(Math.random()*6);
		
		System.out.println("static block  " +rand);
		
	}
	public StaticSuper() {
		System.out.println("constructor");
	}
	public static void main(String[] args) {
		
		
		System.out.println("in main ");
		StaticSuper st=new StaticSuper();
	}
	
	
	
}