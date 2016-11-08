package java_2.lesson_1;

/**
 * Created by DNS PC on 03.11.2016.
 */
public class Horse extends Animal implements Swimable, Jumpable {
    public Horse(String name) {
        this.name = name;
        this.animalType = "Лошадь";
        this.onDistance = true;
        this.maxRunDist = 1000;
    }

    @Override
    public void jump(float height) {
        if (height < 1.0f) {
            System.out.println(animalType + " " + name + " jump ok");
        } else {
            getOutOfDistance("jump");
        }
    }

    @Override
    public void swim(float dist) {
        if (dist < 100) {
            System.out.println(animalType + " " + name + " swim ok");
        } else {
            getOutOfDistance("swim");
        }
    }
}
