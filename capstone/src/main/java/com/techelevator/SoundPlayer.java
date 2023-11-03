package com.techelevator;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.*;

public class SoundPlayer {

    public void playSong() {

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/main/resources/Vendomatic full-01.wav"));
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("problem with song");
            System.out.println(e.getCause());

        }
    }

}