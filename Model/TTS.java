//package alphabetgame.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.speech.Central;
import javax.speech.synthesis.SpeakableAdapter;
import javax.speech.synthesis.SpeakableEvent;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

public class TTS {
    boolean showEvents = false;
    boolean showPropertyChanges = false;
    Synthesizer synthesizer;
            
    public TTS(){
    	System.setProperty("mbrola.base", "C:/mbrola");
        /* kevin16 in a 16khz general domain diphone voice
         */
	Voice kevinHQ = new Voice("mbrola_us2", 
		Voice.GENDER_DONT_CARE, Voice.AGE_DONT_CARE, null);

	try {
	    
	    SynthesizerModeDesc generalDesc = new SynthesizerModeDesc(
		null,          // engine name
                "general",     // mode name
                Locale.US,     // locale
                null,          // running
                null);         // voice
            
	    synthesizer = Central.createSynthesizer(generalDesc);

	    if (synthesizer == null) {
		System.err.println("general domain synthesizer == null");
		System.exit(1);
	    }

	    System.out.print("  Allocating synthesizers...");
	    synthesizer.allocate();

	    /* get general domain synthesizer ready to speak
             */
	    System.out.print("Loading voices...");
	    synthesizer.getSynthesizerProperties().setVoice(kevinHQ);

	    if (showPropertyChanges) {
		synthesizer.getSynthesizerProperties().addPropertyChangeListener(
                    new PropertyChangeListener() {
                        public void propertyChange(
                            PropertyChangeEvent pce) {
                            if (pce.getNewValue() instanceof Voice) {
				String newVoice = 
				    ((Voice) pce.getNewValue()).getName();
				System.out.println(
                                    "  PCE Voice changed to " + newVoice);
			    } else {
				System.out.println(
                                    "  PCE " + pce.getPropertyName()
                                    + " changed from " 
				    + pce.getOldValue() + " to " +
				    pce.getNewValue() + ".");
			    }
			}
		    });
	    }
            
	    if (showEvents) {
		synthesizer.addSpeakableListener(
		    new SpeakableAdapter() {
			public void markerReached(SpeakableEvent e) {
			    dumpEvent(e);
			}
			public void speakableCancelled(SpeakableEvent e) {
			    dumpEvent(e);
			}
			public void speakableEnded(SpeakableEvent e) {
			    dumpEvent(e);
			}
			public void speakablePaused(SpeakableEvent e) {
			    dumpEvent(e);
			}
			public void speakableResumed(SpeakableEvent e) {
			    dumpEvent(e);
			}
			public void speakableStarted(SpeakableEvent e) {
			    dumpEvent(e);
			}
			public void topOfQueue(SpeakableEvent e) {
			    dumpEvent(e);
			}
			public void wordStarted(SpeakableEvent e) {
			    dumpEvent(e);
			}
			private void dumpEvent(SpeakableEvent e) {
			    System.out.println(" EVT: " + e.paramString() 
                                               + " source: " + e.getSource());
			}
		    });
	    }
	    
	    System.out.println("And here we go!");
	    synthesizer.resume();
            synthesizer.getSynthesizerProperties().setSpeakingRate(100.0f);
	    
	    // speak the "Hello world" string
	    //synthesizer.speakPlainText("Hello! My name is Kevin.", null);
	    /*
	    synthesizer.speakPlainText("I am a die phone synthesizer", null);
	    synthesizer.speakPlainText("I have a friend named Alan.", null);
	    synthesizer.speakPlainText("Listen to him count!", null);

	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.speakPlainText("Now listen to me count!", null);
	    synthesizer.speakPlainText("1 2 3 4 5 6 7 8 9 10.", null);

	    synthesizer.speakPlainText(
		    "Now, let's try that a little bit faster.", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.getSynthesizerProperties().setSpeakingRate(240.0f);
	    synthesizer.speakPlainText("1 2 3 4 5 6 7 8 9 10.", null);
	    synthesizer.speakPlainText("That's pretty fast.", null);
	    synthesizer.speakPlainText("Now lets go very slow.", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.getSynthesizerProperties().setSpeakingRate(80.0f);
	    synthesizer.speakPlainText("1 2 3 4 5 6 7 8 9 10.", null);
	    synthesizer.speakPlainText("That is pretty slow.", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.getSynthesizerProperties().setSpeakingRate(100.0f);
	    synthesizer.speakPlainText("Now back to normal", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.getSynthesizerProperties().setPitch(200);
	    synthesizer.speakPlainText("I can talk very high.", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.getSynthesizerProperties().setPitch(50);
	    synthesizer.speakPlainText("and I can talk very low.", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.getSynthesizerProperties().setPitch(100);
	    synthesizer.getSynthesizerProperties().setVolume(.8f);
	    synthesizer.speakPlainText("and I can talk very softly.", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.getSynthesizerProperties().setVolume(1.0f);
	    synthesizer.speakPlainText(
		"I can talk with a higher quality voice", null);
	    synthesizer.speakPlainText(
		    "Here is a low quality tongue twister. "
		    + "She sells seashells by the seashore.", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.getSynthesizerProperties().setVoice(kevinHQ);
	    synthesizer.speakPlainText("And this is high quality. "
		    + "She sells seashells by the seashore.", null);
	    synthesizer.speakPlainText(
		    "The funny thing is, I do not have a tongue.", null);
	    synthesizer.speakPlainText(
		"Hey Alan, what time is it where you are right now?", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.speakPlainText("Is that the exact time?", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.speakPlainText(
		"Is it twenty past six In the morning or the evening?", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.speakPlainText(
		    "Alan and I can talk at the same time", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

	    synthesizer.speakPlainText( "That is a bit confusing.", null);
	    synthesizer.speakPlainText( "Well, thanks. This was fun.", null);
	    synthesizer.speakPlainText("Goodbye everyone.", null);
	    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	    
	    // clean up
	    synthesizer.deallocate();
            */
	}
	catch (Exception e) {
	    e.printStackTrace();
	}

	//System.exit(0);
    }
    
    public void speak(String str){
        try {
            //System.out.println(Thread.currentThread().getName());
            synthesizer.speakPlainText(str, null);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TTS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cancel(){
        synthesizer.cancelAll();
    }
}
