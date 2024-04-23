package ie.tudublin;

import processing.core.PApplet;

public class DiscoBall extends PApplet {

    float angle = 0;
    float rotationSpeed = 0.02f;
    float sphereSize = 10; // Size of individual spheres in the disco ball
    float radius = 100; // Radius of the larger sphere
    int numSpheres = 100; // Number of smaller spheres

    public void settings() {
        size(600, 600, P3D);
    }

    public void setup() {
        noStroke(); 
    }

    public void draw() {
        background(0); 
        translate(width / 2, height / 2);
        rotateY(angle);
        drawDiscoBall();
        angle += rotationSpeed;
    }

    void drawDiscoBall() {
        // Loop through the number of smaller spheres
        for (int i = 0; i < numSpheres; i++) {
            // Calculate the position of the smaller sphere on the surface of the larger sphere
            float theta = random(TWO_PI);
            float phi = acos(2 * random(1) - 1);
            float x = radius * sin(phi) * cos(theta);
            float y = radius * sin(phi) * sin(theta);
            float z = radius * cos(phi);

    
            int color = color(random(255), random(255), random(255));

    
            fill(color);
            pushMatrix();
            translate(x, y, z);
            sphere(sphereSize);
            popMatrix();
        }
    }

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.DiscoBall");
    }
}
