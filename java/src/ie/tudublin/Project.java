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
    AudioBuffer SharedBuffer, drumBuffer;
    
    int mode = 0;

    //Cube Variables
    int OFF_MAX = 300;

    //case 3 variables
    float angle = 0;
    float rotationSpeed = 0.01f; // Reduced rotation speed for the larger sphere
    float sphereSpeed = 0.005f; // Reduced movement speed for the smaller spheres
    float sphereSize = 10; // Size of individual spheres in the disco ball
    float radius = 100; // Radius of the larger sphere
    int numSpheres = 200; // Number of smaller spheres

  
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
        drumBuffer = drums.mix;

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
            
            case 2://lines 
                stroke(255);
                
                for(int i = 0 ; i < drumBuffer.size() ; i ++)
                {

                
                float x = random(width);
                float y = random(height);
                float x2 = random(width);
                float y2 = random(height);
                line(x, y, x2, y2);
    
                //adding colour to the lines
                stroke(random(255), random(255), random(255));
                line(x, y, x2, y2);
    
                //adding thickness to the lines
                strokeWeight(random(8));
                line(x, y, x2, y2);
    
    
                //adding transparency to the lines
                stroke(random(255), random(255), random(255), random(255));
                line(x, y, x2, y2);
    
                //adding lerping to the lines
                float lerp = map(mouseX, 0, width, 0, 1);
                float lerpedX = lerp(x, x2, lerp);
                float lerpedY = lerp(y, y2, lerp);
                line(x, y, lerpedX, lerpedY);
            }


            break;
            case 3://spheres going around

            noStroke(); // No stroke for the spheres
            
            background(0); // Clear the background

            // Translate to the center of the canvas
            translate(width / 2, height / 2);

            // Rotate the scene around its center (larger sphere)
            rotateY(angle);

            // Draw the spinning disco ball
            drawDiscoBall();


            break;
            case 4://mandala 
            translate(width / 2, height / 2); 
        
            for (int i = 0; i < 12; i++) {
                float fx = cos(angle) * 200;
                float fy = sin(angle) * 200;
    
                stroke(random(255), random(255), random(255));
    
                ellipse(fx, fy, 400, 400); 
                rotate(radians(30)); 
            }
            
            angle += 0.05; 
        
            break;
            case 5://sphere in cube 
                drawCubeSphere(0.5f); // You can pass a default value here

            break;
        }
            

        
        
    }
        
        
    

    void drawDiscoBall() {
        // Loop through the number of smaller spheres
        for (int i = 0; i < numSpheres; i++) {
            // Calculate the position of the smaller sphere on the surface of the larger sphere
            float theta = map(i, 0, numSpheres, 0, TWO_PI); // Evenly distribute spheres along the equator
            float phi = map(i % (numSpheres / 2), 0, numSpheres / 2, -HALF_PI, HALF_PI); // Distribute spheres from top to bottom
            float x = radius * sin(phi) * cos(theta);
            float y = radius * sin(phi) * sin(theta);
            float z = radius * cos(phi);

            // Apply some variation in color
            int color = color(random(255), random(255), random(255));

            // Set fill color for the smaller sphere
            fill(color);

            // Draw the smaller sphere at the calculated position
            pushMatrix();
            translate(x, y, z);
            sphere(sphereSize);
            popMatrix();
        }
    }
          
    public void drawCubeSphere(float smoothedAmplitude) {
        background(0);
        lights(); 
        float sphereSize = smoothedAmplitude * 200; 
        float cubeSize = sphereSize * 2; 
        
        // Draw the cube
        stroke(255); 
        noFill();
        translate(width / 2, height / 2, -cubeSize / 2); 
        box(cubeSize); // Draw a cube
        
        // Draw the sphere inside the cube
        noStroke();
        fill(smoothedAmplitude * 255, 255, 255); 
        translate(0, 0, cubeSize / 2 - sphereSize / 2); 
        sphere(sphereSize); 
    }

}        
