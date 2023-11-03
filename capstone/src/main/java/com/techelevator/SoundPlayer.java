package com.techelevator;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.*;

public class SoundPlayer {


    public void playSong() {

        try {
//            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("src/main/resources/Vendomaticfull.wav");
//            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/main/resources/Vendomatic full-01.wav"));
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            //DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("problem with song");
            System.out.println(e.getCause());
        }

    }
    Long currentFrame;
    Clip clip;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
    static String filePath = "src/main/resources/Vendomaticfull.wav";
    public void simpleAudioPlayer(){
        try {
            // create AudioInputStream object
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(filePath));

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception e){
            System.out.println("Something went wrong with the audio");
        }
    }

}