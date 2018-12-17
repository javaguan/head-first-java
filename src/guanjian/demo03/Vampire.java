package guanjian.demo03;

public class Vampire extends Monster{

	
	boolean frighten(byte x) {//参数类型要相同,byte容量小于int，无法覆盖父系方法
		System.out.println("a bite?");
		
		return true;//返回类型要兼容
}
}