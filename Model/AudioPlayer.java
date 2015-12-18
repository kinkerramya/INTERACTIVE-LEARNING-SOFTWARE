import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;




public class AudioPlayer{
	private File audioFile=null;
	private static javax.sound.sampled.Clip clip;
	public void setAudioFile(File f){
	audioFile=f;
	}
	public AudioPlayer(){
		
	}
	public AudioPlayer(File f){
		this();
		setAudioFile(f);
	}
	
	public int getAudioLength(){
		AudioInputStream audioInputStream=null;
		try{
			audioInputStream=AudioSystem.getAudioInputStream(audioFile);
		AudioFormat format=audioInputStream.getFormat();
		long frames=audioInputStream.getFrameLength();
		double durationInSeconds=(frames+0.0)/format.getFrameRate();
		return (int)Math.ceil(durationInSeconds);
		}catch(UnsupportedAudioFileException ex ){
			Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE,null,ex);
		}catch(IOException ex ){
			Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE,null,ex);
		}finally{
			try{
				audioInputStream.close();
			}catch(IOException ex){
				Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE,null,ex);
			}
	}
	return 0;
}
public static Clip getClip(){
	return clip;
}
public void play(){
	AudioInputStream stream=null;
	try{
		stream=AudioSystem.getAudioInputStream(audioFile);
		clip=(Clip)AudioSystem.getClip();
		clip.open(stream);
		clip.start();
		Thread.sleep(getAudioLength()*1000);
	}catch(UnsupportedAudioFileException ex){
		Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE,null,ex);
	}catch(IOException ex){
		Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE,null,ex);
	}catch(LineUnavailableException ex){
		Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE,null,ex);
	}catch(InterruptedException ex){
		Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE,null,ex);
	}finally{
		try{
			stream.close();
		}catch(IOException ex){
			Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}
public static void main(String[] args){
	AudioPlayer player=new AudioPlayer(new File("C:/Users/Sony/workspace/Project1/src/bus.wav"));
	player.play();
	System.out.println(player.getAudioLength());
}
}