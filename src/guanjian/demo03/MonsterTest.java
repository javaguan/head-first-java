package guanjian.demo03;



public class MonsterTest {

public static void main(String[] args) {
Monster[]ma=new Monster[3]	 ;
ma[0]=new Vampire();
ma[1]=new Dragon();
ma[2]=new Monster();
for(int x=0;x<ma.length;x++) {
	
	ma[x].frighten(x);
}

	
	
}
}
