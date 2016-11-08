package java_2.lesson_1;

/**
 * Created by DNS PC on 03.11.2016.
 */
public class OWater extends Obstacle {
    public OWater(float size) {
        this.size = size;
    }

    @Override
    public void doIt(Animal a) {
        if (a instanceof Swimable) {
            ((Swimable) a).swim(size);
        } else {
            a.getOutOfDistance("swim");
        }
    }
}
