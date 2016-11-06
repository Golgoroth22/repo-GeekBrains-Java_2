package java_2.lesson_1;

/**
 * Created by DNS PC on 03.11.2016.
 */
public class OJump extends Obstacle {
    public OJump(float size) {
        this.size = size;
    }

    @Override
    public void doIt(Animal a) {
        if (a instanceof Jumpable) {
            ((Jumpable) a).jump(size);
        } else {
            a.getOutOfDistance("jump");
        }
    }
}
