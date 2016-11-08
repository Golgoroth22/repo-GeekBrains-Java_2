package java_2.lesson_2;

/**
 * Created by Валентин Фалин on 08.11.2016.
 * Урок 2. Исключения.
 * Задание:
 * Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; (другими словами матрица 4x4) 1 3 1 2 2 3 2 2 5 6 7 1 3 3 1 0 Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 * Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 * Ваш метод должен бросить исключения в случаях: ○ Если размер матрицы, полученной из строки, не равен 4x4; ○ Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 * В методе main необходимо вызвать полученный метод, обработать возможные исключения и вывести результат расчета.
 * Комментарий к решению:
 * Исключение для проверки размера матрицы добавлять не стал, т.к. сразу задаю фиксированный размер.
 * Исключение для проверки элемента массива добавил только для вида тоже, т.к. преобразование идет к инту хоть как.
 */
public class Lesson_2 {
    protected static String dzString = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";

    public static void main(String[] args) {
        System.out.println(converter(dzString));
    }

    static int converter(String s) {
        String[][] resultStrMass = new String[4][4];
        int result = 0;
        // Преобразуем в String[][]
        for (int i = 0, j = 7, k = 0; k < resultStrMass[0].length; i += 8, j += 8, k++) {
            resultStrMass[k] = s.substring(i, j).split(" ");
        }
        // Преобразуем String to int и подсчитываем результат
        for (String[] s2 : resultStrMass) {
            for (String s3 : s2) {
                try {
                    if (!checkSmth(s3)) throw new NotIntExeption();
                    result += Integer.parseInt(s3);
                } catch (NotIntExeption e) {
                    e.printStackTrace();
                }
            }
        }
        return result / 2;
    }

    static boolean checkSmth(String s) {
        return true;
    }
}
