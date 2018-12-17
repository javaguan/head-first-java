package guanjian.demo11;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicText1 {
	
	public void  play() {
		
		
		try{
			Sequencer sequencer=MidiSystem.getSequencer();
		System.out.println("We got a sequencer");
	
	}catch(MidiUnavailableException ex) {
		
		System.out.println("Bummer");
	}
	}
	public static void main(String[] args) {
		MusicText1 mt=new MusicText1();
		mt.play();
	}
}
