import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {
    PVector gravity = new PVector(0, 0.4f);
    ArrayList<Particle> particles = new ArrayList<>();
    public static final int numberOfRainParticles = 150;
    public static final int numberOfFireParticles = 400;

    RainSystem RS = new RainSystem(numberOfRainParticles, 600, 600);

    PImage bg;

    public void settings() {
        size(643,360);
        bg = loadImage("img.png");
        bg.resize(643, 360);
    }

    public void setup() {
        RS.createSystem();
    }

    public void draw() {
        background(bg);
        RS.update(this);

    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}