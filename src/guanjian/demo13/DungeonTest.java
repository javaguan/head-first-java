package guanjian.demo13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class DungeonTest {
	public static void main(String[] args) {
		DungeonGame dungeonGame=new DungeonGame();
		System.out.println(dungeonGame.getX()+dungeonGame.getY()+dungeonGame.getZ());
		try {
		FileOutputStream fileOutputStream=new FileOutputStream(new File("mat.ser"));
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(dungeonGame);
		objectOutputStream.close();
		FileInputStream fileInputStream=new FileInputStream("mat.ser");
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
	dungeonGame=(DungeonGame)  objectInputStream.readObject();
		fileInputStream.close();
		}catch(Exception ex) {ex.printStackTrace();}
		
		
		System.out.println(dungeonGame.getX()+dungeonGame.getY()+dungeonGame.getZ());
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
