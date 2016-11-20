package java_2.lesson_5;

/**
 * Created by Валентин Фалин on 20.11.2016.
 */
public class MyThread extends Thread {
    private int size;
    float arr[];

    public MyThread(int firstSize, int secondSize) {
        this.size = secondSize - firstSize;
        this.arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public float[] getArr() {
        return arr;
    }
}
