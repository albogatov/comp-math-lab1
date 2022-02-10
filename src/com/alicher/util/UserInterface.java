package com.alicher.util;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
     * Режим взаимодействия.
     */
    private final boolean interactionMode;

    /**
     * Стандартный конструктор.
     *
     * @param r  откуда считывать.
     * @param w  куда записывать.
     * @param im режим взаимодействия (true - интерактивный).
     */
    public UserInterface(Reader r, Writer w, boolean im) {
        this.writer = w;
        this.interactionMode = im;
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