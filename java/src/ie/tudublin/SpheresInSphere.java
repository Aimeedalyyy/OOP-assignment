package ie.tudublin;

import processing.core.PApplet;

public class SpheresInSphere extends PApplet {

    int OFF_MAX = 3000;
    int numSpheres = 200; // Number of smaller spheres

    public void settings() {
        size(1080, 1060, P3D);
    }

    public void draw() {
        background(0);
        translate(width / 2, height / 2, -OFF_MAX);
        rotateX(frameCount * 0.01f);
        rotateY(frameCount * 0.01f);
        rotateZ(frameCount * 0.01f);

        float spacing = OFF_MAX * 0.7f; // Adjust the spacing between smaller spheres
        float radius = OFF_MAX * 0.3f; // Adjust the radius of the larger sphere

        // Draw the larger sphere
        stroke(255);
        noFill();
        sphere(radius);

        // Draw the smaller spheres inside the larger sphere
        for (int i = 0; i < numSpheres; i++) {
            float theta = random(TWO_PI);
            float phi = acos(2 * random(1) - 1);
            float x = radius * sin(phi) * cos(theta);
            float y = radius * sin(phi) * sin(theta);
            float z = radius * cos(phi);

            pushMatrix();
            translate(x, y, z);
            fill(random(255), random(255), random(255)); // Random fill color for each sphere
            sphere(10); // Adjust the size of smaller spheres
            popMatrix();
        }
    }

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.SpheresInSphere");
    }
}
