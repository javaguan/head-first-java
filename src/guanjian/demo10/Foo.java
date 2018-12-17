package guanjian.demo10;

 public class Foo {
 static final int x=8;
public  void go(final int x) {
	System.out.println(x);
}
	
	public static void main(String[] args) {
		Foo foo=new Foo();
		foo.go(8);
	}
}
