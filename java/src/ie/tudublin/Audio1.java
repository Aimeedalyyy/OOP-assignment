package ie.tudublin;

import ddf.minim.AudioBuffer;
//In the context of audio processing, an "audiobuffer" typically refers to a data structure used to hold audio samples. Each element of the audiobuffer represents the amplitude (or intensity) of the audio signal at a specific point in time.
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

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
        ap = minim.loadFile("tomp3.cc - 08 PsychNerD and Marco G  More Cowbell.mp3", 1024);
        ap.play();
        ab = ap.mix;
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
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2; // middle of canvas
        float cy = height / 2;///middle of canvas
 
        switch (mode) 
        {
		    case 1:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    float hue = map(i, 0, ab.size() , 0, 256); //makes the line a rainbow across it
                    stroke(hue, 255, 255);
                    noFill();
                    line(i , cy + ab.get(i) * cy, cy + ab.get(i) * cy, i);
                }
                break;
            case 2:
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    float hue = map(i, 0, ab.size() , 0, 256); //makes the line a rainbow across it
                    stroke(hue, 255, 255);
                    noFill();
                    line(i , cy, i ,cy + ab.get(i) * cy);
                }
            break;
            case 3:
                for(int i = 0 ; i < ab.size() ; i ++)
                    {
                    float hue = map(i, 0, ab.size() , 0, 256); //makes the line a rainbow across it
                    stroke(hue, 255, 255);
                    noFill();
                    line(i , 800, i , 800 + ab.get(i) * 800);//top line
                    line(i , 0, i , 0 + ab.get(i) * i ); // bottom line 
                    line(800 , i , 800 + ab.get(i) * 800 , i);// right line
                    line(0 , i , 0 + ab.get(i) * i, i);//left line
                    }
            break;
        case 4:
            background(0);
            for(int i = 0 ; i < ab.size() ; i ++)
            {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
            }
            average= sum / (float) ab.size();
            break;
            
        case 5:
        
            
            break;

        }
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
