package java_2.lesson_6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Валентин Фалин on 24.11.2016.
 * Урок 6. Работа с сетью.
 * Задание:
 * Разобраться с исходным кодом клиентской и серверной части, и для закрепления написать консольные эхо-сервер и клиент.
 */
public class MyServer {
    private ServerSocket server = null; // Создаём пустую ссылку на сервер
    public final static int PORT = 8888;
    Socket s = null; // Создаём пустую ссылку на сокет

    public MyServer() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен. Ожидание клиентов...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            // Как только клиент подключится, создаем сокет (соединение)
            s = server.accept();
            // В отдельном потоке запускаем обработчик этого клиента
            Thread thread = new Thread(new ClientHandler(s));
            thread.start();
            System.out.println("Клиент подключился");
            thread.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                System.out.println("Server closed");
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new MyServer().start();
    }
}

