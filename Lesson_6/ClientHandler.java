package java_2.lesson_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Валентин Фалин on 24.11.2016.
 */
public class ClientHandler implements Runnable {
    private Socket s;
    private PrintWriter out;
    private Scanner in;
    private static int CLIENTS_COUNT = 0;
    private String name;

    public ClientHandler(Socket s) {
        try {
            // при создании обработчика, даем ему ссылку на обрабатываемое соединение (сокет)
            this.s = s;
            out = new PrintWriter(s.getOutputStream()); // PrintWriter служит для отсылки сообщений клиенту
            in = new Scanner(s.getInputStream()); // Scanner предназначен для чтения сообщений от клиента
            CLIENTS_COUNT++; // Подсчитываем количество клиентов
            name = "Клиент #" + CLIENTS_COUNT;
        } catch (IOException e) {
        }
    }

    @Override
    public void run() { // метод обмена сообщениями
        while (true) { // запускаем бесконечный цикл
            if (in.hasNext()) { // если от клиента пришло сообщение
                String w = in.nextLine(); // читаем его
                System.out.println(name + ": " + w); // печатаем это сообщение в консоль
                out.println("echo: " + w); // и отсылаем обратно с добавлением фразы "echo: "
                out.flush();
                // если клиент прислал "end", выходим из бесконечного цикла
                if (w.equalsIgnoreCase("END")) break;
            }
        }
        try {
            System.out.println("Клиент отключился");
            s.close(); // закрываем сокет
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
