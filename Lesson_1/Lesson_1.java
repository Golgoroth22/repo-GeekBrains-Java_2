package java_2.lesson_1;

/**
 * Created by Валентин Фалин on 06.11.2016.
 * Урок 1. Объектно-ориентированное программирование Java.
 * Задание:
 * 1. Разобраться с имеющимся кодом;
 * 2. Добавить класс Команда, который будет содержать: название команды, массив из 4-х
 * участников (т.е. в конструкторе можно сразу указывать всех участников), метод для вывода
 * информации о членах команды прошедших дистанцию, метод вывода информации обо всех
 * членах команды.
 * 3. Добавить класс ПолосаПрепятствий, в котором будут находиться: массив препятствий, метод,
 * который будет просить команду пройти всю полосу;
 */
public class Lesson_1 {
    public static void main(String[] args) {
        Course c = new Course(new OJump(0.8f), new OWater(30), new OCross(500)); // Создаем полосу препятствий
        Team t1 = new Team("The Green Lanthern Corps", new Horse("Lana"), new Dog("Rax"), new Cat("Jozy"), new Duck("Bo")); // Создаем первую команду
        Team t2 = new Team("The Sinestro Corps", new Horse("Bilabo"), new Duck("Qaqo"), new Cat("Tiger"), new Duck("Peggy")); // Создаем вторую команду
        c.doIt(t1); // Просим первую команду пройти полосу
        c.doIt(t2); // Просим вторую команду пройти полосу
        t1.showResults(); // Показываем результаты первой команды
        t2.showResults(); // Показываем результаты второй команды
    }
}

class Team {
    protected String teamName;
    protected Animal[] teamMass = new Animal[4];

    Team(String teamName, Animal animal1, Animal animal2, Animal animal3, Animal animal4) {
        this.teamName = teamName;
        this.teamMass[0] = animal1;
        this.teamMass[1] = animal2;
        this.teamMass[2] = animal3;
        this.teamMass[3] = animal4;
    }

    void printTeamInfo() {
        System.out.print("Team \"" + teamName + "\": ");
        for (Animal a : teamMass) {
            System.out.print(a.getName() + " ");
        }
        System.out.println();
    }

    public Animal[] getTeamMass() {
        return teamMass;
    }

    void showResults() {
        System.out.print("Who can DoIt in team \"" + teamName + "\": ");
        for (Animal a : teamMass) {
            if (a.isOnDistance()) System.out.print(a.getName() + " ");
        }
        System.out.println();
    }
}

class Course {
    protected Obstacle[] obstacles = new Obstacle[3];

    Course(Obstacle obstacle1, Obstacle obstacle2, Obstacle obstacle3) {
        this.obstacles[0] = obstacle1;
        this.obstacles[1] = obstacle2;
        this.obstacles[2] = obstacle3;
    }

    void doIt(Team team) {
        for (Animal a : team.getTeamMass()) {
            for (Obstacle o : obstacles) {
                o.doIt(a);
                if (!a.isOnDistance()) break;
            }
        }
    }
}
