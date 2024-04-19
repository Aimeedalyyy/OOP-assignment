package ie.tudublin;

import processing.core.PApplet;

public class sphere extends PApplet {

    float angle = 0;
    float rotationSpeed = 0.02f;
    float sphereSize = 100;

    public void settings() {
        size(600, 400, P3D);
    }

    public void setup() {
        // Set up the scene
        fill(255, 0, 0); // Fill color for the sphere (red)
        noStroke(); // No stroke for the sphere
    }

    public void draw() {
        background(0); // Clear the background

        // Translate to the center of the canvas
        translate(width / 2, height / 2);

        // Rotate the scene around its center
        rotateY(angle);

        // Draw the spinning sphere
        drawSphere();

        // Increment the angle for rotation
        angle += rotationSpeed;
    }

    void drawSphere() {
        // Draw the sphere at the translated position
        sphere(sphereSize);
    }

    public static void main(String[] args) {
        PApplet.main("sphere");
    }
}
