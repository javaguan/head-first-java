package guanjian.demo15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
	
	public static void main(String[] args) {
		DailyAdviceClient client=new DailyAdviceClient();

		client.go();
	
		}
	public void go() {
		try {
		Socket s=new Socket("127.0.0.1",4241);
		InputStreamReader inputStreamReader=new InputStreamReader(s.getInputStream());
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		String advice =bufferedReader.readLine();
		System.out.println("Today you should:"+advice);
		bufferedReader.close();
		}catch(IOException ex) {ex.printStackTrace();}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
