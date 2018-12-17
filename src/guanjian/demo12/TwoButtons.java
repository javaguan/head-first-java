package guanjian.demo12;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TwoButtons {
	JFrame frame;
	JLabel label;
	public static void main(String[] args) {
		TwoButtons gui=new TwoButtons();
		gui.go();
	}
	public void go () {
		
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton labelButton=new JButton("change label");
		labelButton.addActionListener(new LabelListener());
		JButton colorbutton=new JButton("change color");
		colorbutton.addActionListener(new ColorListener());
		label=new JLabel("I'm a label");
		MyDrawPanel drawPanel=new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.SOUTH, colorbutton);
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.setSize(300, 300);
		frame.setVisible(true);;
		
		
	}
	
	class LabelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			label.setText("hahahha");
		}
		
	}
	
class ColorListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			frame.repaint();
		}
		
	}
	
	
	
	
	
	

}
