package Finalproject;

import com.softsynth.jmsl.JMSL;
import com.softsynth.jmsl.JMSLRandom;

public class Test2Color implements ColorDataProvider {

	
	public double getRedColor() {
		return JMSLRandom.choose();			
	}
	
	public double getBlueColor () {
		return JMSLRandom.choose();
		
	}
	public double getGreenColor () {
		return JMSLRandom.choose();
		
	}

	public double getXaxis () {
		return JMSLRandom.choose();
		
	}
	public double getYaxis () {
		return JMSLRandom.choose();
		
	}	
	public double getZaxis () {
		return JMSLRandom.choose();
		
	}
	
	
	
	public static void main (String[] args) {
		ColorMusicPiece colormusicPiece =  new ColorMusicPiece();
		colormusicPiece.setMyColorDataProvider(new Test1Color());
		colormusicPiece.setRepeats (5);
		colormusicPiece.launch (JMSL.now());
	}



}
