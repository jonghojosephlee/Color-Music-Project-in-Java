package Finalproject;

import com.softsynth.jmsl.MusicJob;
import Finalproject.ColorMusicInstrument;
import Finalproject.ColorMusicPiece;
import com.softsynth.jmsl.JMSL;

public class ColorMusicPerformance {
	public static void main(String[] args) {

        ColorMusicPiece colormusicPiece =  new ColorMusicPiece();
        colormusicPiece.setMyColorDataProvider(new Test1Color());
        colormusicPiece.setRepeats (30);

        ColorMusicInstrument colormusicInstrument = new ColorMusicInstrument();
        colormusicInstrument.build();
        colormusicInstrument.pack();
        colormusicInstrument.setVisible(true);

// here is where you take the ins from ColorMusicInstrument and give it to the music job:
        colormusicPiece.setInstrument(colormusicInstrument.getInstrument());

        colormusicPiece.launch(JMSL.now());
    
	}	
}
