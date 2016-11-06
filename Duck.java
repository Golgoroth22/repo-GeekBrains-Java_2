package java_2.lesson_1;

/**
 * Created by DNS PC on 03.11.2016.
 */
public class Duck extends Animal implements Swimable {

    public Duck(String name) {
        this.name = name;
        this.animalType = "Утка";
        this.onDistance = true;
        this.maxRunDist = 50;
    }

    @Override
    public void swim(float dist) {
        if (dist < 1500) {
            System.out.println(animalType + " " + name + " swim ok");
        } else {
            getOutOfDistance("swim");
        }
    }
}
