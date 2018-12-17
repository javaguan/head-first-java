package guanjian.demo11;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MIniMIniMusicApp {
	
public static void main(String[] args) {
	MIniMIniMusicApp mini=new MIniMIniMusicApp();
	mini.play();
	
}
public void play() {
	
	
	try {
		
		
	Sequencer player=MidiSystem.getSequencer();
		player.open();
		Sequence seq=new Sequence(Sequence.PPQ, 4);
		Track track=seq.createTrack();
		
		ShortMessage first=new ShortMessage();
		first.setMessage(192,1,102,0);
		MidiEvent  changeInstrument=new MidiEvent(first, 1);
		track.add(changeInstrument);
		
		
		
		
		ShortMessage a=new ShortMessage();
		a.setMessage(144,1,44,100);
		MidiEvent noteOn=new MidiEvent(a, 1);
		track.add(noteOn);
		
		ShortMessage b=new ShortMessage();
		b.setMessage(128,1,44,100);
		MidiEvent noteOff=new MidiEvent(b, 3);
		track.add(noteOff);
		
		player.setSequence(seq);
		player.start();
	}
	
	
	catch(Exception ex){
		
		ex.printStackTrace();
		
		
		
		
		
	}
}
}
