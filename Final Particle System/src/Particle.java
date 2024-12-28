import processing.core.PApplet;
import processing.core.PVector;

public class Particle {
    public String getSize() {
        return "SizeX: " + sizeX + " SizeY: " + sizeY;
    }

    // TODO: add attributes
    protected PVector pos;
    protected PVector vel;
    protected PVector acc;
    protected float sizeX;
    protected float sizeY;

    public Particle(float x, float y, float sizeX, float sizeY) {
        pos = new PVector();
        pos.set(x, y);
        vel = new PVector();
        acc = new PVector();

        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }



    public PVector getVel() {
        return vel;
    }

    public Particle setVel(PVector vel) {
        this.vel = vel;
        return this;
    }

    public PVector getAcc() {
        return acc;
    }

    public Particle setAcc(PVector acc) {
        this.acc = acc;
        return this;
    }

    public PVector getPos() {
        return pos;
    }

    public Particle setPos(PVector pos) {
        this.pos = pos;
        return this;
    }

    public void update() {
        // update velocity and position
        vel.add(acc);
        pos.add(vel);
        acc.setMag(0);
    }

    public void applyForce(PVector f) {
        // a force affects the acceleration
        acc.add(f);

    }

    public void draw(PApplet window) {
        window.fill(18,22,127);
        window.ellipse(pos.x, pos.y, sizeX, sizeY);
    }
}
