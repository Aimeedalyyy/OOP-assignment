package ie.tudublin;

import processing.core.PApplet;

public class cubeSphere extends PApplet {
   
    public void settings() {
        size(800, 600, P3D);
    }

    public void setup() {
        // Additional setup code if needed
    }

    public void draw() {
        drawCubeSphere(0.5f); // You can pass a default value here
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
   
    public static void main(String[] args) {
        PApplet.main("ie.tudublin.cubeSphere");
    }
}
