package java_2.lesson_1;

/**
 * Created by DNS PC on 03.11.2016.
 */
public class Dog extends Animal implements Swimable, Jumpable {

    public Dog(String name) {
        this.name = name;
        this.animalType = "Собака";
        this.onDistance = true;
        this.maxRunDist = 800;

    }

    @Override
    public void swim(float dist) {
        if (dist < 300) {
            System.out.println(animalType + " " + name + " swim ok");
        } else {
            getOutOfDistance("swim");
        }
    }

    @Override
    public void jump(float height) {
        if (height < 0.5f) {
            System.out.println(animalType + " " + name + " jump ok");
        } else {
            getOutOfDistance("jump");
        }
    }
}
