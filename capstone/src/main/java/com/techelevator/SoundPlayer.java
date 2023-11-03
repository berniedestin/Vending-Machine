package com.techelevator;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.*;

public class SoundPlayer {


    public void playSong() {

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("src/audio/Vendomaticfull.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
//            System.out.println("problem with song");
//            System.out.println(e.getCause());
        }

    }

}