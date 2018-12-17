package guanjian.demo10;

public class TextBox {

	
	Integer i=5;
	int j=12;
	
	public static void main(String[] args) {
		TextBox b=new TextBox();
		b.go();
		
		
	}
	public void go() {
		j=i;
		System.out.println(i);
		System.out.println(j);
	}
	
}
