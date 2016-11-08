package java_2.lesson_1;

/**
 * Created by DNS PC on 03.11.2016.
 */
public class Animal {
    protected String name;
    protected String animalType;
    protected boolean onDistance;
    protected float maxRunDist;

    public boolean isOnDistance() {
        return onDistance;
    }

    public void cross(float dist) {
        if (dist < maxRunDist) {
            System.out.println(animalType + " " + name + " cross ok");
        } else {
            getOutOfDistance("cross");
        }
    }

    public void getOutOfDistance(String reason) {
        onDistance = false;
        System.out.println(animalType + " " + name + " reason " + reason + " fail");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal() {

    }

    public void printInfo() {
        System.out.println("name " + name);
    }
}
