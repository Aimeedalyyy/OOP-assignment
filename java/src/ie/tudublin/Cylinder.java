package ie.tudublin;
import processing.core.PApplet;

public class Cylinder extends PApplet {

    public void settings() {
        size(1000, 800);
    }

    public void setup() {
        background(0);
    }

    public void draw() {
        stroke(255);
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

        //making the lines disappear after 5 seconds
        if (mousePressed) {
            background(0);
        }

        

    }



    
}
