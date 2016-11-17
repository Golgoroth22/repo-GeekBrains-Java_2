package java_2.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Валентин Фалин on 12.11.2016.
 * Урок 3. Collections Framework
 * Задание:
 * 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
 *    а. Посчитать сколько раз встречается каждое слово;
 *    б. Найти список слов, из которых состоит текст (дубликаты не считать);
 * 2. Написать простой класс ТелефонныйСправочник:
 *    а. В каждой записи всего три поля: Фамилия, Телефон, email;
 *    б. Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили
 *       телефон), и отдельный метод для поиска email по фамилии. Следует учесть, что под одной
 *       фамилией может быть несколько записей.
 */
public class Lesson_3 {
    private String str;
    private ArrayList<String> dzList = new ArrayList<>();

    public Lesson_3(String str) {
        this.str = str;
        String[] mass = str.split(" ");
        for (String s : mass) {
            dzList.add(s);
        }
    }

    public void checkElementsInList() {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : dzList) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> o : set) {
            System.out.print(o.getKey() + ": " + o.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        // Задание 1.
        String inputString = "Класс ArrayList представляет собой динамический массив , размер которого может увеличиваться и " +
                "уменьшаться по мере надобности . Стандартный массив в Java имеют фиксированную длину . " +
                "По существу , класс ArrayList представляет собой списочный массив объектных ссылок переменной длины .";
        Lesson_3 l3 = new Lesson_3(inputString);
        l3.checkElementsInList(); // Список слов и количество их повторений
        // Задание 2.
        Phonebook phoneBook = new Phonebook();
        phoneBook.addNote("Wayne", "8-343-343-00-00", "batman111@gmail.com");
        phoneBook.addNote("Allen", "8-764-456-46-88", "flash44@gmail.com");
        phoneBook.addNote("Curry", "8-835-357-84-45", "aquaman343@gmail.com");
        phoneBook.findNumber("Allen");// Поиск номера по фамилии
        phoneBook.findEmail("Allen");// Поиск email по фамилии
    }
}
