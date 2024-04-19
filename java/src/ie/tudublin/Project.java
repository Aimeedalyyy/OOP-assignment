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

    //Cube Variables
    int OFF_MAX = 300;

  
    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		
	}

    public void settings()
    {
        size(1080, 1060, P3D);
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
                background(0);

                float amplitude = SharedBuffer.level();
                float rotationSpeed = map(amplitude, 0.0f, 1.0f, 0.01f, 0.1f);

                translate(width / 2, height / 2, -OFF_MAX);
                rotateX(frameCount * rotationSpeed);
                rotateY(frameCount * 0.01f);
                rotateZ(frameCount * 0.01f);

                for (int xo = -OFF_MAX; xo <= OFF_MAX; xo += 50) {
                    for (int yo = -OFF_MAX; yo <= OFF_MAX; yo += 50) {
                        for (int zo = -OFF_MAX; zo <= OFF_MAX; zo += 50) {
                        pushMatrix();
                        translate(xo, yo, zo);
                        rotateX(frameCount * rotationSpeed);
                        rotateY(frameCount * 0.01f);
                        rotateZ(frameCount * 0.01f);
                        fill(colorFromOffset(xo), colorFromOffset(yo), colorFromOffset(zo));
                        box(20);
                        popMatrix();
                    }
                    }
                }
        

            
         
                break;
            
            case 2:

                break;
        
            default:
    }
        
        
    }
            

}        
