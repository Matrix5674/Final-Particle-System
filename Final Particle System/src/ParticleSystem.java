import processing.core.PApplet;

import java.util.ArrayList;

public class ParticleSystem {
    protected int numOfParticles;
    protected ArrayList<Particle> particleList;
    protected int width, height;
    protected float x, y, sizeX, sizeY;

    public ParticleSystem(int numOfParticles, int width, int height){
        this.numOfParticles = numOfParticles;
        particleList = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    public void createSystem(){
        for (int i = 0; i < numOfParticles; i++) {
            addParticles(1);
        }
    }


    public void update(){
        for (Particle p : particleList){
            p.update();
            if (x > width || y > height){
                x = 0;
                y = 0;
            }
        }
    }

    // draw()
    public void draw(PApplet window){
        for (Particle p : particleList){
            p.draw(window);
        }
    }

    // addParticles()
    public void addParticles(int amount){
        for (int i = 0; i < amount; i++) {
            particleList.add(new Particle(0, 0, 1, 2));
        }
    }

    public int getNumOfParticles() {
        return numOfParticles;
    }

    public ArrayList<Particle> getParticleList() {
        return particleList;
    }


}
