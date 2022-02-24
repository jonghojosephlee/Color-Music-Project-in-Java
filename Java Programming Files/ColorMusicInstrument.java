package Finalproject;

import javax.swing.JFrame;

import com.softsynth.jmsl.jsyn2.JSynMusicDevice;
import com.softsynth.jmsl.jsyn2.JSynUnitVoiceInstrument;
import com.softsynth.jmsl.util.EventDistributions;
import com.softsynth.jmsl.util.LinearInterpolator;
import com.softsynth.jmsl.view.MusicShapeEditor;

import java.awt.*;
import java.awt.event.*;
import com.softsynth.jmsl.*;
import algomusicfall2021.jmsl.MusicJobExample;


import Finalproject.ColorMusic;



public class ColorMusicInstrument extends JFrame implements ActionListener {
	
//	MusicShape myMusicShape;
	JMSLMixerContainer mixer;
	MusicShapeEditor musicShapeEditor;
	Button startButton;
	Button stopButton;
	// a polyphonic JMSL instrument that allocates and plays JSyn voices.
	JSynUnitVoiceInstrument ins;
	
	public JSynUnitVoiceInstrument getInstrument () {
		return ins;
	}
	
	public void build() {
		JMSLRandom.randomize();
		initJMSL();
		initMusicDevices();
		initMixer();
		initInstrument();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				cleanup();
				System.exit(0);
			}
		});	
	}
	
	private void initJMSL() {
		JMSL.scheduler = new EventScheduler();
		JMSL.scheduler.start();
		JMSL.clock.setAdvance(0.2);
	}
	
	void initMusicDevices() {
		JSynMusicDevice dev = JSynMusicDevice.instance();
		dev.open();
	}
	
	void initMixer() {
		mixer = new JMSLMixerContainer();
		mixer.start();
	}
	
	void initInstrument() {
		// SUBSTITUTE YOUR UnitVoice Class name HERE!!!
		ins = new JSynUnitVoiceInstrument (7, Finalproject.ColorMusic.class.getName());
		mixer.addInstrument((Instrument) ins);
		DimensionNameSpace dns = ((Instrument) ins).getDimensionNameSpace();
		System.out.println(dns.toString());
//		loop through each dimension and show its name and number:
		for (int i=0; i < dns.dimension(); i++) {
			String dimensionName = dns.getDimensionName(i);
			System.out.println(i+") "+ dimensionName);
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == startButton) {
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
		}
		if (source == stopButton) {
			startButton.setEnabled(true);
			stopButton.setEnabled(false);
		}
	}
	
	public static void main(String[] args) {
		ColorMusicInstrument colormusicInstrument = new ColorMusicInstrument();
		colormusicInstrument.build();
		colormusicInstrument.pack();
		colormusicInstrument.setVisible(true);
	}
	
}

	
	
	
class MusicShapeScrambler extends MusicJob implements Playable {

	public double repeat(double playTime) {
		Instrument ins = getInstrument ();

		
		return playTime;
	}

	

	
	
	MusicShapeEditor editor;
	/**
	 * Pass in the MusicShapeEditor just so we can call refresh() on it after scarmalbing. Pass in
	 * null if you don't care
	 */
	
	MusicShapeScrambler(MusicShapeEditor editor) {
		this.editor = editor;
	}
}


