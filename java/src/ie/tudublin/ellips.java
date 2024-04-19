package ie.tudublin;

import processing.core.PApplet;

public class ellips extends PApplet {

    float sphereSize = 200; // Increased size of the spheres

    public void settings() {
        size(1000, 800, P3D);
    }

    public void setup() {
        background(0);
        lights();
        ambientLight(200,0,0);
        pointLight(255, 255, 255, 0, 0, 500);
    }

    public void draw() {
        background(0);
        translate(width / 2, height / 2, -1000);
        rotateX(frameCount * 0.01f);
        rotateY(frameCount * 0.01f);

        float distance = 400;
        for (int i = 0; i < 8; i++) {
            noStroke();
            fill(random(255), random(255), random(255));
            drawSphere(cos(radians(i * 45)) * distance, sin(radians(i * 45)) * distance, 0, sphereSize);
        }

        noStroke();
        fill(random(255), random(255), random(255));
        drawSphere(0, 0, 0, sphereSize);

        float s = map(sin(frameCount * 0.01f), -1, 1, sphereSize, sphereSize + 50);
        drawSphere(0, 0, 0, s);

        noFill();
        stroke(0);
        strokeWeight(4);
        drawSphere(0, 0, 0, sphereSize);
    }

    private void drawSphere(float x, float y, float z, float r) {
        pushMatrix();
        translate(x, y, z);
        sphereDetail(40);
        sphere(r);
        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.ellips");
    }
}
