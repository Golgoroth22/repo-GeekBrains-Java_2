package java_2.lesson_5;

/**
 * Created by Валентин Фалин on 20.11.2016.
 * Урок 5. Многопоточность.
 * Задание:
 * Необходимо написать два метода, которые делают следующее:
 *    a. Создают одномерный длинный массив, например:
 *    b. static final int size = 10000000;
 *    c. static final int h = size / 2;
 *    d. float[] arr = new float[size];
 *    e. Заполняют этот массив единицами;
 *    f. Засекают время выполнения: long a = System.currentTimeMillis();
 *    g. Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 *    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 *    h. Проверяется время окончания метода System.currentTimeMillis();
 *    i. В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 *    Чем отличается первый метод от второго:
 *    Первый бежит по массиву и высчитывает значения.
 *    Второй разбивает массив на два массива, в двух потоках высчитывает новые значения, и потом
 *    склеивает эти массивы обратно в один.
 */
public class Lesson_5 {
    static final int size = 10000000;
    static final int h = size / 2;
    float arr[];

    public Lesson_5() {
        this.arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    public void firstCounter() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public void secondCounter() {
        long a = System.currentTimeMillis();
        MyThread thread1 = new MyThread(0, h);
        MyThread thread2 = new MyThread(h, size);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(thread1.getArr(), 0, this.arr, 0, thread1.getArr().length);
        System.arraycopy(thread2.getArr(), 0, this.arr, thread1.getArr().length, thread2.getArr().length);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args) {
        Lesson_5 l5_1 = new Lesson_5();
        l5_1.firstCounter();
        Lesson_5 l5_2 = new Lesson_5();
        l5_2.secondCounter();
    }
}



