package com.java_2.lesson_4;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Валентин Фалин on 17.11.2016.
 * Урок 4. Продвинутые вопросы написания графического интерфейса
 * Задание:
 * 1. Создать окно для клиентской части чата (большое текстовое поле для отображения переписки, 
 * однострочное текстовое поле для ввода сообщений, кнопка для отсылки сообщений). 
 * Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter. 
 * "Отправленное" сообщение должно появиться в большом текстовом поле, и быть продублировано в текстовый файл.
 * 2. Для записи в файл можно использовать PrintWriter pw = new PrintWriter(new FileWriter("1.txt")); pw.println(...);
 */
public class Lesson_4 {
    private static final String WELCOME = "Welcome, ";
    private String name = "";

    public static void main(String[] args) throws IOException, InterruptedException {
        Lesson_4 uiClient = new Lesson_4();

        PrintWriter printWriter = new PrintWriter(new FileWriter("E:/111.txt"));

        JFrame frame = new JFrame("Чат");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        center(frame);

        JTextArea serverTextField = new JTextArea();
        serverTextField.setEditable(false);
        JTextField ourTextField = new JTextField();
        JButton sendButton = new JButton("Отправить");
        frame.getRootPane().setDefaultButton(sendButton);

        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.gridheight = 10;
        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(serverTextField, constraints);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 10;
        frame.add(ourTextField, constraints);

        constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 11;
        frame.add(sendButton, constraints);

        frame.setVisible(true);

        sendButton.addActionListener((event) -> {
            String text = ourTextField.getText();
            if (text.length() != 0) {
                String senderPrefix = (uiClient.getName() != null) ? "[" + uiClient.getName() + "] " : "";
                if (uiClient.name.equals("")) {
                    uiClient.setName(text);
                    serverTextField.append(text + "\n");
                    serverTextField.append(WELCOME + text + "\n");
                } else {
                    serverTextField.append(senderPrefix + text + "\n");
                    writeToServer(senderPrefix + text, printWriter);
                }
                ourTextField.setText("");
            }
        });

        new Thread(() -> {
            serverTextField.append("Connected to server\n");
            serverTextField.append("Enter nickname: ");
            while (true) {
                // TODO: 17.11.2016 прием сообщений с сервера
            }
        }).start();
    }

    private static void writeToServer(String s, PrintWriter printWriter) {
        printWriter.println(s);
        printWriter.flush();
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static void center(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
