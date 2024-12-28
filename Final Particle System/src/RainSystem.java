import processing.core.PApplet;
import processing.core.PVector;

public class RainSystem extends ParticleSystem {

    public RainSystem(int numOfParticles, int width, int height) {
        super(numOfParticles, width, height);
    }

    @Override
    public void createSystem() {
        for (int i = 0; i < numOfParticles; i++) {
            PVector position = new PVector((float) Math.random() * width, (float) Math.random() * height);
            PVector velocity = new PVector(0, 15);
            PVector acceleration = new PVector(0, 0);

            Particle particle = new Particle(position.x, position.y, 2, 5)
                    .setVel(velocity)
                    .setAcc(acceleration);

            particleList.add(particle);
        }
    }


    public void update(PApplet window) {
        for (Particle particle : particleList) {
            particle.update();

            // Reset position if the particle falls below the height
            if (particle.getPos().y > height) {
                particle.setPos(new PVector((float) Math.random() * width, 0));
            }

            // Draw the particle
            particle.draw(window);
        }
    }
}
