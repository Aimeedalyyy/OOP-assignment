package ie.tudublin;

import processing.core.PApplet;

public class DiscoBall extends PApplet {

    float angle = 0;
    float rotationSpeed = 0.01f; // Reduced rotation speed for the larger sphere
    float sphereSpeed = 0.005f; // Reduced movement speed for the smaller spheres
    float sphereSize = 10; // Size of individual spheres in the disco ball
    float radius = 100; // Radius of the larger sphere
    int numSpheres = 200; // Number of smaller spheres

    public void settings() {
        size(600, 600, P3D);
    }

    public void setup() {
        // Set up the scene
        noStroke(); // No stroke for the spheres
    }

    public void draw() {
        background(0); // Clear the background

        // Translate to the center of the canvas
        translate(width / 2, height / 2);

        // Rotate the scene around its center (larger sphere)
        rotateY(angle);

        // Draw the spinning disco ball
        drawDiscoBall();

        // Increment the angle for rotation (larger sphere)
        angle += rotationSpeed;
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

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.DiscoBall");
    }
}
