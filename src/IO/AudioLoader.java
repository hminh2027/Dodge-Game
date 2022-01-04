package IO;

import javax.sound.sampled.*;
import java.io.File;

public class AudioLoader {

    public Clip getAudio(String s) {
        try {
            File file = new File("resources/audio/"+s);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            return clip;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
