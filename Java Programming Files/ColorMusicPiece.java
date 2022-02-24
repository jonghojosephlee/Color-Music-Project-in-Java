package Finalproject;

import com.softsynth.jmsl.MusicJob;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import com.softsynth.jmsl.*;
import com.softsynth.jmsl.jsyn2.JSynMusicDevice;
import com.softsynth.jmsl.jsyn2.JSynUnitVoiceInstrument;

import Finalproject.ColorMusic;


public class ColorMusicPiece extends MusicJob{
	
	ColorDataProvider myColorDataProvider;
	
	public ColorDataProvider getMyColorDataProvider () {
		return myColorDataProvider;
	}
	
	public void setMyColorDataProvider(ColorDataProvider myColorDataProvider) {
		this.myColorDataProvider = myColorDataProvider;
		
	}
	
	public double repeat (double playTime) {
		
		double redColor = myColorDataProvider.getRedColor();
		double greenColor = myColorDataProvider.getGreenColor();
		double blueColor = myColorDataProvider.getBlueColor();
		double xaxis = myColorDataProvider.getXaxis();
		double yaxis = myColorDataProvider.getYaxis();
		double zaxis = myColorDataProvider.getZaxis();
		
		double filterfreq = convertXaxisToFilterFreq(xaxis);
		double freqosc2 = convertYaxisToFreqOsc2(yaxis);
		double looprate = convertZaxisToLoopRate(zaxis);
		double frequency = convertRedColorToFrequency(redColor);
		double amplitude = convertGreenColorToAmplitude(greenColor);
		double modulation = convertBlueColorToModulation(blueColor);
		
		
		
		//To set values in insData
		if (getInstrument() != null) {
			MusicShape s = new MusicShape(getInstrument().getDimensionNameSpace());
			s.print();
			double[] insData = s.getDefaultArray();
			
			int indexOfFilterFreq = getInstrument().getDimensionNameSpace().getDimension("FilterFreq");
			insData[indexOfFilterFreq] = filterfreq;
			
			int indexOfFreqOsc2 = getInstrument().getDimensionNameSpace().getDimension("FreqOsc2");
			insData[indexOfFreqOsc2] = freqosc2;
			
			int indexOfModulation = getInstrument().getDimensionNameSpace().getDimension("Modulation");
			insData[indexOfModulation] = modulation;
			
			int indexOfLoopRate = getInstrument().getDimensionNameSpace().getDimension("LoopRate");
			insData[indexOfLoopRate] = looprate;
			

			
			// do the other inputs here as well
			getInstrument().play(playTime, 1.0, insData);
		
		} else {
			System.out.println("ColorMusicPiece is playing silently without an instrument");
		}
		
		
		System.out.println("red color" + redColor 
				+ ", greencolor= " + greenColor 
				+ "blue color" + blueColor 
				+ "X Axis" + xaxis 
				+ "Y Axis" + yaxis 
				+ "Z Axis" + zaxis 
				
				+ ", freq" + frequency 
				+ ", amp" +amplitude 
				+ ", mod" + modulation 
				+ ", filter freq " + filterfreq 
				+ ", freq osc 2 " + freqosc2
				+ ", loop rate" + looprate);
		
		
		
		
		return playTime + 1;
		
		
	}
	
	
	private double convertXaxisToFilterFreq(double xaxis) {
		double scaledValue = xaxis;
		if (getInstrument() != null) {
			int indexOfFilterFreq = getInstrument().getDimensionNameSpace().getDimension("FilterFreq");
			double lowLimit = getInstrument().getDimensionNameSpace().getLowLimit(indexOfFilterFreq);
			double highLimit = getInstrument().getDimensionNameSpace().getHighLimit(indexOfFilterFreq);
			
			scaledValue = (highLimit - lowLimit) * xaxis + lowLimit;
			System.out.println("xaxis=" + xaxis + ", scaledValue=" + scaledValue + ", lowLimit=" + lowLimit
			+ ", highLimit = " + highLimit);		
			
		}
		
		return scaledValue;
		
			
		}
		
	
	private double convertYaxisToFreqOsc2(double yaxis) {
		double scaledValue =yaxis;
		if (getInstrument() != null) {
			int indexOfFreqOsc2 = getInstrument().getDimensionNameSpace().getDimension("FreqOsc2");
			double lowLimit = getInstrument().getDimensionNameSpace().getLowLimit(indexOfFreqOsc2);
			double highLimit = getInstrument().getDimensionNameSpace().getHighLimit(indexOfFreqOsc2);
			
			scaledValue = (highLimit - lowLimit) * yaxis + lowLimit;
			System.out.println("yaxis=" + yaxis + ", scaledValue=" + scaledValue + ", lowLimit=" + lowLimit
			+ ", highLimit = " + highLimit);		
			
		}
		
		return scaledValue;

		
	}	
	private double convertZaxisToLoopRate(double zaxis) {
		double scaledValue =zaxis;
		if (getInstrument() != null) {
			int indexOfLoopRate = getInstrument().getDimensionNameSpace().getDimension("LoopRate");
			double lowLimit = getInstrument().getDimensionNameSpace().getLowLimit(indexOfLoopRate);
			double highLimit = getInstrument().getDimensionNameSpace().getHighLimit(indexOfLoopRate);
			
			scaledValue = (highLimit - lowLimit) * zaxis + lowLimit;
			System.out.println("zaxis=" + zaxis + ", scaledValue=" + scaledValue + ", lowLimit=" + lowLimit
			+ ", highLimit = " + highLimit);		
			
		}

		return scaledValue;

		
	}
	
	private double convertGreenColorToAmplitude(double greenColor) {
		double scaledValue =greenColor;
		if (getInstrument() != null) {
			int indexOfAmplitude = getInstrument().getDimensionNameSpace().getDimension("Amplitude");
			double lowLimit = getInstrument().getDimensionNameSpace().getLowLimit(indexOfAmplitude);
			double highLimit = getInstrument().getDimensionNameSpace().getHighLimit(indexOfAmplitude);
			
			scaledValue = (highLimit - lowLimit) * greenColor + lowLimit;
			System.out.println("greencolor=" + greenColor + ", scaledValue=" + scaledValue + ", lowLimit=" + lowLimit
			+ ", highLimit = " + highLimit);		
			
		}

		return scaledValue;
		
		

		
	}
	
	private double convertBlueColorToModulation(double blueColor) {
		double scaledValue = blueColor;
		if (getInstrument() != null) {
			int indexOfModulation = getInstrument().getDimensionNameSpace().getDimension("Modulation");
			double lowLimit = getInstrument().getDimensionNameSpace().getLowLimit(indexOfModulation);
			double highLimit = getInstrument().getDimensionNameSpace().getHighLimit(indexOfModulation);
			
			scaledValue = (highLimit - lowLimit) *blueColor + lowLimit;
			System.out.println("bluecolor=" + blueColor + ", scaledValue=" + scaledValue + ", lowLimit=" + lowLimit
			+ ", highLimit = " + highLimit);	
		}
		
		return scaledValue;
			
		
	}
	
	private double convertRedColorToFrequency(double redColor) {

		double lowPitch = 13;
		double highPitch = 70;
		
		double scaledpitch = (highPitch - lowPitch) * redColor + lowPitch;
		
//		double freq = redColor * 440;
//		return freq;
		return scaledpitch;
	}

		
	
		
		
		
	

}
