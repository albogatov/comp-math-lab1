package com.alicher.util;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

/**
 * Класс, реализующий взаимодействие с пользователем.
 */
public class UserInterface {
    /**
     * Сканнер.
     */
    private final Scanner scanner;
    /**
     * Куда идет запись.
     */
    private final Writer writer;

    /**
     * Стандартный конструктор.
     *
     * @param r  откуда считывать.
     * @param w  куда записывать.
     */
    public UserInterface(Reader r, Writer w) {
        this.writer = w;
        this.scanner = new Scanner(r);
    }

    /**
     * Метод, считывающий введенную пользователем строку.
     *
     * @return введенная строка.
     */
    public String read() {
        return scanner.nextLine();
    }

    public double readDouble() {
        return scanner.nextDouble();
    }

    public int readInt() {
        return scanner.nextInt();
    }

    /**
     * Метод, проверяющий наличие несчитанных строк.
     *
     * @return true, если они есть, иначе false.
     */
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    /**
     * Метод, пишущий сообщение на вывод.
     *
     * @param message сообшение.
     * @throws IOException в случае ошибки ввода/вывода.
     */
    public void write(String message) throws IOException {
        writer.write(message);
        writer.flush();
    }

    /**
     * Метод, демонстрирующий сообщение пользователю.
     *
     * @param message сообщение.
     * @throws IOException в случае ошибки ввода/вывода.
     */
    public void displayMessage(String message) throws IOException {
        write(message + "\n");
    }
}