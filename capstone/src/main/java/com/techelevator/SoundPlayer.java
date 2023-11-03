package com.techelevator;
import java.io.File;
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

    public void playBuyItem(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/main/resources/vendsfx.wav"));
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();
            clip.loop(0);

        } catch (Exception e) {
            System.out.println("problem with buy item sound");

        }
    }
    public void playFeedMoney(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/main/resources/coinsfx.wav"));
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();
            clip.loop(0);

        } catch (Exception e) {
            System.out.println("problem with feed money sound");

        }
    }
    public void playGetChange(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/main/resources/changesfx.wav"));
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();
            clip.loop(0);

        } catch (Exception e) {
            System.out.println("problem with get change sound");

        }
    }

    public void playSadSound(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/main/resources/wompsfx.wav"));
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.start();
            clip.loop(0);

        } catch (Exception e) {
            System.out.println("problem with sad sound");

        }
    }


}