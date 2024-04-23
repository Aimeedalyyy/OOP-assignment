package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
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
    AudioInput mixedInput;
    
    int mode = 0;

    //Cube Variables
    //int OFF_MAX = 300;

    //case 3 variables
    float angle = 0;
    float sphereSpeed = 0.005f; // Reduced movement speed for the smaller spheres
    float sphereSize = 10; // Size of individual spheres in the disco ball
    float radius = 100; // Radius of the larger sphere
    int numSpheres = 200; // Number of smaller spheres

    //case 5 variables
    float minSize = 50; // Minimum size for the cube and sphere
    float maxSize = 400; // Maximum size for the cube and sphere


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
        size(1000, 1000, P3D);
    }

    public void setup()
    {
        background(0);
        minim = new Minim(this);

        //audio files
        banjo = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/Banjo.wav" , 1024); //1024 is the size of the buffer we are using 
        boathorn = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/boathorn.mp3", 1024);
        drums = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/drums.mp3", 1024);
        guitar = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/Guitar.wav", 1024);
        whistle = minim.loadFile("/Users/aimeedaly/Desktop/OOP-assignment/java/data/whistle.mp3" , 1024);
        
        //play all files at the same time

        mixedInput = minim.getLineIn();
        
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

        lerpedBuffer = new float[SharedBuffer.size()];
    }
    float off = 0;
    
    
    public void draw()
    {
        float amplitude = SharedBuffer.level();
        float rotationSpeed = map(amplitude, 0.0f, 1.0f, 0.01f, 0.1f);
        colorMode(HSB);
        //background(0);
        stroke(255);
        float SPamplitude = SharedBuffer.level();

        if (mousePressed) 
        {
            background(0);
        }

        switch (mode) {
            case 1:
            //lines 
            background(0);    
            float x = random(width);
            float y = random(height);
            float x2 = random(width);
            float y2 = random(height);
            stroke(255);


            // adding colour to the lines
            strokeWeight(random(8));
            stroke(SPamplitude + random(255), 255, 255);
            line(x, y, x2, y2);
            
            break;
            
            case 2:
            ///mandala 
            background(0);
            translate(width / 2, height / 2); 

            for (int i = 0; i < SharedBuffer.size(); i++) {
                noFill();
                float fx = cos(angle) * 200;
                float fy = sin(angle) * 200;

                strokeWeight(10);
                stroke(random(20),  255, 255);
    
                ellipse(fx, fy, 400, 400); 
                rotate(radians(30)); 
            }
            
            //angle += 0.05; 
                
            break;
            case 3://DiscoBall
                background(0);
                amplitude = SharedBuffer.level();
                rotationSpeed = map(amplitude, 0.0f, 1.0f, 0.01f, 0.1f);
        
                int OFF_MAX = 3000;
                int numSpheres = 200; // Number of smaller spheres
                background(0);
                translate(width / 2, height / 2, -OFF_MAX);
                rotateX(frameCount * rotationSpeed);
                rotateY(frameCount * 0.01f);
                rotateZ(frameCount * 0.01f);

                //float spacing = OFF_MAX * 0.7f; // Adjust the spacing between smaller spheres
                float radius = OFF_MAX * 0.3f; // Adjust the radius of the larger sphere

                // Draw the middle sphere
                stroke(255);
                noFill();
                strokeWeight(1);
                sphere(radius);

                // Draw the smaller spheres inside the larger sphere
                for (int i = 0; i < numSpheres; i++) 
                {
                
                fill(255, 255, 0);
                float theta = random(TWO_PI);
                float phi = acos(2 * random(1) - 1);
                float thisx = radius * sin(phi) * cos(theta);
                float thisy = radius * sin(phi) * sin(theta);
                float z = radius * cos(phi);
                
                pushMatrix();
                translate(thisx, thisy, z);
                sphere(10); // Adjust the size of smaller spheres
                popMatrix();
                }
            

            break;
            case 4://rotating cube
            
            background(0);
            OFF_MAX = 300;
            amplitude = SharedBuffer.level();
            rotationSpeed = map(amplitude, 0.0f, 1.0f, 0.01f, 0.1f);
            float hue;

            translate(width / 2, height / 2, -OFF_MAX);
            rotateX(frameCount * 0.01f);
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
                    fill(amplitude + 100,  255 , 255);
                    stroke(0);
                    box(20);
                    popMatrix();
                }
                }
            }
            break;
            
            
            
            
            
        
            case 5://sphere in cube 
                SPamplitude = SharedBuffer.level();

                // Normalize the amplitude to fit within the range of 0 to 1
                float normalizedAmplitude = map(SPamplitude, 0, 1, 0, 1);
        
                background(0);
                lights(); 
                float sphereSize = normalizedAmplitude * 200; 
                float cubeSize = sphereSize * 2; 
                
                // Draw the cube
                stroke(255); 
                noFill();
                translate(width / 2, height / 2, -cubeSize / 2); 
                box(cubeSize); // Draw a cube
        
                // Draw the sphere inside the cube
                noStroke();
                fill(SPamplitude * 150, 255, 255); 
                translate(0, 0, cubeSize / 2 - sphereSize / 2); 
                sphere(sphereSize); 
            
            break;
            case 6://flower                                                                                                                                                                                                                                                   
                
                float SphereSize = 200; // Increased size of the spheres

                amplitude = SharedBuffer.level();
                rotationSpeed = map(amplitude, 0.0f, 1.0f, 0.01f, 0.1f);
                background(0);
                translate(width / 2, height / 2, -1000);
                rotateX(frameCount * 0.01f);
                rotateY(frameCount * 0.01f);
                float distance = 400;

                for (int i = 0; i < SharedBuffer.size(); i++) {
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], SharedBuffer.get(i), 0.1f);
                }

                for (int i = 0; i < 8; i++){

                    noStroke();
                    hue = map(lerpedBuffer[i % lerpedBuffer.length], 0, 1, 0, 255);
                    hue = hue + 100;
                    fill(hue,  255 , 255);
                    drawSphere(cos(radians(i * 45)) * distance, sin(radians(i * 45)) * distance, 0, SphereSize);
                }

                noStroke();
                fill(30 , 255 , 255);
                drawSphere(0, 0, 0, SphereSize);

                float s = map(sin(frameCount * 0.01f), -1, 1, SphereSize, SphereSize + 50);
                drawSphere(0, 0, 0, s);

                noFill();
                stroke(0);
                strokeWeight(4);
                drawSphere(0, 0, 0, SphereSize);
            break;
        }    
    }
        
        
   


    private void drawSphere(float x, float y, float z, float r) {
        pushMatrix();
        translate(x, y, z);
        sphereDetail(40);
        sphere(r);
        popMatrix();
    }
}        
