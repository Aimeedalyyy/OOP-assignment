package ie.tudublin;

import ddf.minim.AudioBuffer;
//In the context of audio processing, an "audiobuffer" typically refers to a data structure used to hold audio samples. Each element of the audiobuffer represents the amplitude (or intensity) of the audio signal at a specific point in time.
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import ddf.minim.analysis.FFT;

public class Project extends PApplet
{
    Minim minim;
    AudioPlayer banjo , boathorn , drums , guitar , whistle;
    AudioBuffer SharedBuffer;

    int mode = 0;
    int OFF_MAX = 300;
    FFT fft;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
        println(mode);
		
	}

    public void settings()
    {
        size(800, 800);//size of window
    }

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

        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }
    float off = 0;

    int colorFromOffset(int offset) {
            return (int) ((offset + OFF_MAX) / (2.8 * OFF_MAX) * 255);
        }


    public void draw()
    {
        colorMode(HSB);
        background(0);
        stroke(255);

        switch (mode) {
            case 1:
                float cx = width/2;
                float cy = height /2;

                circle(cx, cy , 500);
                for(int i = 0 ; i < SharedBuffer.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, SharedBuffer.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * cy * 4.0f;
                    line(i, cy + f, i, cy - f);                    
                }
         
                break;
        
            default:
                break;
        }

        
        
    }
            

}        
