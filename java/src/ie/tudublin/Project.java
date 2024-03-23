package ie.tudublin;

import ddf.minim.AudioBuffer;
//In the context of audio processing, an "audiobuffer" typically refers to a data structure used to hold audio samples. Each element of the audiobuffer represents the amplitude (or intensity) of the audio signal at a specific point in time.
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Project extends PApplet
{
    Minim minim;
    AudioPlayer ap , ap1;
    AudioBuffer ab , ab1;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(800, 800);//size of window
    }

    public void setup()
    {
        minim = new Minim(this);

        //audio files
        //ap = minim.loadFile("tomp3.cc - 08 PsychNerD and Marco G  More Cowbell.mp3", 1024);
        ap1 = minim.loadFile("Mel.mp3" , 1024); //1024 is the size of the buffer we are using 

        //play all files at the same time
        ap1.play();
        //ap.play();

        //audio buffers
        ab1 = ap1.mix;
        //ab = ap.mix;

        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }
    float off = 0;

    @Override
    public void draw()
    {
        colorMode(HSB);
        background(0);
        stroke(255);
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2; // middle of canvas
        float cy = height / 2;///middle of canvas
 

        for(int i = 0 ; i < ab1.size() ; i ++)
        {
            //float hue = map(i, 0, ab.size() , 0, 256); //makes the line a rainbow across it
            stroke(255, 255, 255);
            noFill();
            //circle(200 , 400 , ab.get(i) * cy);
            stroke(200, 255, 255);
            circle(300 , 400 , ab1.get(i) * cy);
        }
            

    }        
}
