package ie.tudublin;

import processing.core.PApplet;

public class Cube extends PApplet {

    int OFF_MAX = 300;

    public void settings() {
        size(1080, 1060, P3D);
    }

    public void draw() {
        background(0);
        translate(width / 2, height / 2, -OFF_MAX);
        rotateX(frameCount * 0.01f);
        rotateY(frameCount * 0.01f);
        rotateZ(frameCount * 0.01f);

        for (int xo = -OFF_MAX; xo <= OFF_MAX; xo += 50) {
            for (int yo = -OFF_MAX; yo <= OFF_MAX; yo += 50) {
                for (int zo = -OFF_MAX; zo <= OFF_MAX; zo += 50) {
                    pushMatrix();
                    translate(xo, yo, zo);
                    rotateX(frameCount * 0.01f);
                    rotateY(frameCount * 0.01f);
                    rotateZ(frameCount * 0.01f);
                    fill(colorFromOffset(xo), colorFromOffset(yo), colorFromOffset(zo));
                    box(20);
                    popMatrix();
                }
            }
        }
    }

    int colorFromOffset(int offset) {
        return (int) ((offset + OFF_MAX) / (2.8 * OFF_MAX) * 255);
    }

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.Cube");
    }
}
