package ie.tudublin;

import ddf.minim.AudioBuffer;
//In the context of audio processing, an "audiobuffer" typically refers to a data structure used to hold audio samples. Each element of the audiobuffer represents the amplitude (or intensity) of the audio signal at a specific point in time.
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Project extends PApplet
{
    Minim minim;
    AudioPlayer banjo , boathorn , drums , guitar , whistle;
    AudioBuffer SharedBuffer;

    @Override
    public void settings() {
        // Set the size of the window
        size(800, 600);
        background(0);
    }

    @Override
    public void setup()
    {
        minim = new Minim(this);

        //audio files
        banjo = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/Banjo.wav" , 1024); //1024 is the size of the buffer we are using 
        boathorn = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/boathorn.mp3", 1024);
        drums = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/drums.mp3", 1024);
        guitar = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/Guitar.wav", 1024);
        whistle = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/whistle.mp3" , 1024);
        
        //play all files at the same time
        
        drums.play();
        boathorn.play();
        banjo.play();
        guitar.play();
        whistle.play();

        //shared audio buffers
        SharedBuffer = banjo.mix; 

        
    }


    public void keyPressed()
    {
        if(key == '1')
        {
           Reacts draw1 = new Reacts();
            draw1.Setbuff(SharedBuffer);
            draw1.draw(); 
        }
        
    }
    

    
}
