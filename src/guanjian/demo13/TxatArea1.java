package guanjian.demo13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TxatArea1 implements ActionListener {
JTextArea text;
public static void main(String[] args) {
	TxatArea1 gui=new TxatArea1();
gui.go();
}
public void actionPerformed(ActionEvent ev) {
	
	text.append("µãµãµã \n");
}
	
	public void go() {
		
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JButton button=new JButton("click me");
		button.addActionListener(this);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		text=new JTextArea(10,20);
		text.setLineWrap(true);
		JScrollPane scrollPane=new JScrollPane(text);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);
		frame.setSize(350,300);
		frame.setVisible(true);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
