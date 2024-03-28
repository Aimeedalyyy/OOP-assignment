package ie.tudublin;

import processing.core.PApplet;

public class Mandala extends PApplet {

    float angle = 0;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        noFill();
        background(0); 
    }

    public void draw() {
        translate(width / 2, height / 2); 
        
        for (int i = 0; i < 12; i++) {
            float x = cos(angle) * 200;
            float y = sin(angle) * 200;

            stroke(random(255), random(255), random(255));

            ellipse(x, y, 400, 400); 
            rotate(radians(30)); 
        }
        
        angle += 0.05; 
    }

    public static void main(String[] args) {
        PApplet.main("Mandala");
    }
}
