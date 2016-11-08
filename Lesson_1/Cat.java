package java_2.lesson_1;

/**
 * Created by DNS PC on 03.11.2016.
 */
public class Cat extends Animal implements Jumpable {

    public Cat(String name) {
        this.name = name;
        this.animalType = "Кошка";
        this.onDistance = true;
        this.maxRunDist = 500;
    }

    @Override
    public void jump(float height) {
        if (height < 1.5f) {
            System.out.println(animalType + " " + name + " jump ok");
        } else {
            getOutOfDistance("jump");
        }
    }
}
