package guanjian.demo15;


import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class DailyAdviceServer {
	String []adviceList= {"³Ô³Ô·¹","Ë¯Ë¯¾õ","ºÈºÈË®","Ð¦Ò»Ð¦","É¢É¢²½"};
			public void go() {
				
				
				try {
				ServerSocket serverSocket=new ServerSocket(4240);
				while(true) {
					Socket sock=serverSocket.accept();
					PrintWriter writer=new PrintWriter(sock.getOutputStream());
				String advice=getAdvice();
				writer.println(advice);
				
					writer.close();
					System.out.println(advice);//ÎªºÎ²»Ö´ÐÐ£¿£¿£¿£¿
				}
				}catch(Exception ex) {ex.printStackTrace();}
			}
				
			public String getAdvice() {
				int random=(int)(Math.random()*adviceList.length);
				return adviceList[random];
			}	
				
				public static void main(String[] args) {
					DailyAdviceServer dailyAdviceServer=new DailyAdviceServer() ;
					dailyAdviceServer.go();
					
					
				}
				
				
				
				
				
				
				
				
				
			}
			
			
			

	
	
	
	
	
	
	
	
	
	
	
	
	


