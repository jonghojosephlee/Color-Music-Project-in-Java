package Finalproject;

import com.softsynth.jmsl.JMSL;




public class Test1Color implements ColorDataProvider {
	
	public double getRedColor() {
		return 0.5;			
	}
	
	public double getBlueColor () {
		return 0.5;
		
	}
	public double getGreenColor () {
		return 0.5;
		
	}

	public double getXaxis () {
		return 0.5;
		
	}
	public double getYaxis () {
		return 0.5;
		
	}	
	public double getZaxis () {
		return 0.5;
		
	}
	
	
	
	public static void main (String[] args) {
		ColorMusicPiece colormusicPiece =  new ColorMusicPiece();
		colormusicPiece.setMyColorDataProvider(new Test1Color());
		colormusicPiece.setRepeats (5);
		colormusicPiece.launch (JMSL.now());
	}


}
