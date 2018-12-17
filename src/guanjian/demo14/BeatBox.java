package guanjian.demo14;



import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;





public class BeatBox  {
JPanel mianPanel;
ArrayList<JCheckBox> checkboxList;
Sequencer sequencer;
Sequence sequence;
Track track;
JFrame theFrame;
String[]instrumentNames= {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare","Crash Cymbal","Hand clap","High Tom","High Bingo","Maracas","Whistle","Low Clap","Cowball","Vibraslap","Low-mid Tom","High Agogo","Open Hi Conga"};
int []instruments= {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};//樂器關鍵字	



	public static void main(String[] args) {
		BeatBox box=new BeatBox();
		box.buildGUI();
	}
	
	
	
	public void buildGUI() {
		theFrame  =new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout=new BorderLayout();
		JPanel backgroung=new JPanel(layout) ;
		backgroung.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));//設置面板空白邊緣
		checkboxList=new ArrayList<JCheckBox>();//
		Box buttenBox=new Box(BoxLayout.Y_AXIS);
		JButton start =new JButton("START");
		start.addActionListener(new MyStartListener());
		buttenBox.add(start);
		JButton stop=new JButton("STOP");
		stop.addActionListener(new MyStopListener());
		buttenBox.add(stop);
		JButton upTempo=new JButton(" tempo up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttenBox.add(upTempo);
		JButton downTempo=new JButton("tempo down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttenBox.add(downTempo);
		JButton save=new JButton("Save");
		save.addActionListener(new MySendListener());
		buttenBox.add(save);
		JButton read=new JButton("Read");
		read.addActionListener(new MyReadListener());
		buttenBox.add(read);
		
		
		
		
		
		Box nameBox=new Box(BoxLayout.Y_AXIS);
		for (int i=0;i<16;i++) {
			nameBox.add(new Label(instrumentNames[i]));	
		}
		backgroung.add(BorderLayout.WEST,nameBox);
		
		backgroung.add(BorderLayout.EAST,buttenBox);
		theFrame.getContentPane().add(backgroung);
		GridLayout grid=new GridLayout(16,16);//GridLayout從左到右，從上至下16*16
		grid.setHgap(2);//上下間距
		grid.setVgap(1);//左右間距
		JPanel   mainPanel=new JPanel(grid);
		backgroung.add(BorderLayout.CENTER,mainPanel);
		for(int m=0;m<256;m++) {
			JCheckBox c=new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);	
		}
		
		setUpMiDi();
		theFrame.setBounds(50,50,300,300);
		theFrame.pack();//依據組件設置窗口大小（自適應）,全都能放得下
		theFrame.setVisible(true);	
	}
	
	
	public void setUpMiDi() {
		
		try {
	 sequencer=MidiSystem.getSequencer();
		sequencer.open();
	 sequence=new Sequence(Sequence.PPQ, 4);
	 track=sequence.createTrack();
	 sequencer.setTempoInBPM(120);
		}catch(Exception ex) {ex.printStackTrace();}	
	}
	
	
	public void makeTracks(int[]list) {
	for(int k=0;k<16;k++) {

		int key=list[k];
		if(key!=0) {
			track.add(makeEvent(144,9,key,100,k));
			track.add(makeEvent(128,9,key,100,k+1));
		}
		}		
	}
	public  MidiEvent makeEvent(int comd,int chan ,int one,int two,int tick) {
		
		MidiEvent event=null;
		try {
			ShortMessage aMessage=new ShortMessage();
			aMessage.setMessage(comd,chan,one,two);
			event=new MidiEvent(aMessage, tick);
			
			
		}catch(Exception ex) {ex.printStackTrace();}
		return event;
		
	}
	public class MyStartListener implements ActionListener{
		
		public void actionPerformed(ActionEvent a) {
			buildTrackAndStart();
			
		}
	}
		public class MyStopListener implements ActionListener{
			
			public void actionPerformed(ActionEvent a) {
				sequencer.stop();
				
			}
		}
			public class MyUpTempoListener implements ActionListener{
				
				public void actionPerformed(ActionEvent a) {
					float tempo=sequencer.getTempoFactor();
					sequencer.setTempoFactor((float)(tempo*1.03));
				}
			}
				public class  MyDownTempoListener implements ActionListener{
					
					public void actionPerformed(ActionEvent a) {
					
						float tempo=sequencer.getTempoFactor();
						sequencer.setTempoFactor((float)(tempo*.97));	
					}
	}
	
	public void buildTrackAndStart(){
		
	sequence.deleteTrack(track);
	track=sequence.createTrack();
	for(int i=0 ;i<16;i++) {
		int[]trackList=new int[16];
		int Key=instruments[i];
		for(int j=0;j<16;j++) {
			JCheckBox jc=(JCheckBox) checkboxList.get(j+16*i);
			if(jc.isSelected())
			{  trackList[j]=Key;
		}else 
		{trackList[j]=0;}
		}
		makeTracks(trackList);
		track.add(makeEvent(176, 1, 127, 0, 16));//延長了幾個拍？？
	}
	track.add(makeEvent(192,9,1,0, 15));//確保16拍有事件，否則beatbox不會循環！！！	
		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch(Exception ex) {ex.printStackTrace();}
		
	
	}
	//==========================儲存與還原（序列與解序列化）========================================================	
		
	public class MySendListener implements ActionListener{
		public  void actionPerformed(ActionEvent event) {
			boolean[] chectboxstate=new boolean[256];
			for(int i=0;i<256;i++) {
				JCheckBox box=checkboxList.get(i);
				if(box.isSelected()) {chectboxstate[i]=true;}
				
				else {chectboxstate[i]=false;}
			}
			try {
				FileOutputStream fileOutputStream=new FileOutputStream(new File("checkbox.ser"));
				ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(chectboxstate);
				objectOutputStream.close();
				
			}catch(Exception ex) {ex.printStackTrace();}
			
			
			
			
			
		}		
	}
	public class MyReadListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		boolean[]chectboxstate=null;//將數組對象的值置空
		try {
		FileInputStream fileInputStream=new FileInputStream(new File("checkbox.ser"));
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		 chectboxstate= (boolean[])  objectInputStream.readObject();
		 objectInputStream.close();
		for(int i=0;i<256;i++) {
			JCheckBox check= (JCheckBox) checkboxList.get(i);
			if(chectboxstate[i]) {
			check.setSelected(true);}
			else {check.setSelected(false);}
		}
		}catch(Exception ex) {ex.printStackTrace();}
			
			sequencer.stop();
			buildTrackAndStart();
			
		}
		
		
		
	}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

