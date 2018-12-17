package guanjian.demo13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Pane11 {

	public static void main(String[] args) {
		Pane11 gui =new Pane11();
		gui.go();
		
	}
	public void go() {
		
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		JButton button =new JButton("click me");
		
		JButton button2 =new JButton("hahahaaaaaaaaaaaaaaaaa");
		JButton button3 =new JButton("shdhadfhadfhadaaaaaaa");

		frame.getContentPane().add(BorderLayout.EAST ,panel);
		
		frame.setSize(200,200);
		frame.setVisible(true);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		
	}
	
	
	
	
	
}
