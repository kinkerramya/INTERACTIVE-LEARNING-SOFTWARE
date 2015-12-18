import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class TTScustom {
//private static final String VOICENAME_Kevin="kevin";
//System.setProperty("mbrola.base", "C:/mbrola");
private String text;
public TTScustom(String text){
	this.text=text;
	}
public void speak(){
	System.setProperty("mbrola.base", "C:/mbrola");
	Voice voice;
	VoiceManager voiceManager=VoiceManager.getInstance();
	voice=voiceManager.getVoice("mbrola_us1");
	voice.allocate();
	voice.speak(text);
}
}
