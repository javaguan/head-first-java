package guanjian.demo12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniMusicPlayer3 {
	public MidiEvent makeMidiEvent(int comd,int chan,int one ,int two,int tick){
		MidiEvent event=null;
		try {
			
			ShortMessage a=new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event=new MidiEvent(a, tick);
		}catch (Exception e) {
			
		}
		return event;
		
	}
	class MyDrawpanel3 extends JPanel implements ControllerEventListener{
	
	boolean msl=false;
	public void controlChange(ShortMessage event) {//ShortMessage???
		
		
		
		msl=true;
		repaint();
	}
	public void paintComponent(Graphics g) {
		if(msl) {
			
			Graphics2D g2=(Graphics2D) g;
			int r=(int)(Math.random()*255);
			int gr=(int)(Math.random()*255);
			
			int b=(int)(Math.random()*255);
			Color color =new Color(r,gr,b);
			g.setColor(color);
			int ht=(int)((Math.random()*120)+10);
			int width=(int)((Math.random()*120)+10);
			int x=(int)((Math.random()*40)+10);
			int y=(int)((Math.random()*40)+10);
			g.fillRect(x, y, width, ht);
			msl=false;
			
		}
		
	}
	
	
	}
	static JFrame f=new JFrame("My first music video");
	static  MyDrawpanel3 d3;
	public static void main(String[] args) {
		MiniMusicPlayer3 m3=new MiniMusicPlayer3();
		m3.go();
		
	}
	public void setUpGui() {
		d3=new  MyDrawpanel3();
		f.setContentPane(d3);
		f.setBounds(30,30,300,300);
		f.setVisible(true);
	}
	public void go() {
	setUpGui();
	try {
		Sequencer sequencer=MidiSystem.getSequencer();
		sequencer.open();
		sequencer.addControllerEventListener(d3, new int[] {127});//???d3
		Sequence seq= new Sequence(Sequence.PPQ,4);
		Track track=seq.createTrack();
		int r=0;
		for(int i=0;i<600;i++) {
			r=(int)((Math.random()*50)+1);
			track.add(makeMidiEvent(144, 1, r,100, i));
			track.add(makeMidiEvent(176, 1, 127,0, i));
			track.add(makeMidiEvent(144, 1, r,100, i+2));
		}
		sequencer.setSequence(seq);
		sequencer.setTempoInBPM(120);
		sequencer.start();
		}catch(Exception e) {}
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	

}
