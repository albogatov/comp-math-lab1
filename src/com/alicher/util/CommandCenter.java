package com.alicher.util;

import com.alicher.cmd.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс отвечающий за распознование и вызов команд.
 */
public class CommandCenter {
    /**
     * Объект центра управления командами.
     */
    public static CommandCenter commandCenter;
    /**
     * Список всех возможных команд.
     */
    private final HashMap<String, Command> commands = new HashMap<>();

    /**
     * Конструктор центра комманд, где добавляются все возможные команды.
     */
    public CommandCenter() {
        addCmd(new SolveFromFile());
        addCmd(new SolveFromInput());
        addCmd(new SolveRandom());
        addCmd(new Exit());
    }

    /**
     * Метод передачи команды в конструктор.
     *
     * @param cmd Команда.
     */
    public void addCmd(Command cmd) {
        commands.put(cmd.getCommand(), cmd);
    }

    /**
     * Метод, распознающий команду в строке, введенной пользователем.
     *
     * @param cmdLine Строка, содержащая команду.
     * @return Объект класса соответсвующей команды.
     */
    public Command getCmd(String cmdLine) {
        return commands.getOrDefault(cmdLine, null);
    }

    /**
     * Метод, возвращающий единственный объект класса. Реализация шаблона "Синглтон".
     *
     * @return Объект центра управления командами.
     */
    public static CommandCenter getInstance() {
        if (commandCenter == null)
            return new CommandCenter();
        return commandCenter;
    }

    /**
     * Метод, возврашающий полный список всех команд.
     *
     * @return Список команд.
     */
    public List<Command> retrieveAllCommands() {
        return commands.keySet().stream().map(commands::get).collect(Collectors.toList());
    }

    /**
     * Метод, вызывающий исполнение команды.
     *
     * @param ui                 объект, через который ведется взаимодействие с пользователем.
     * @param line               часть строки пользовательского ввода, содержающая команду.
     * @throws IOException в случае ошибки ввода/вывода.
     */
    public void executeCommand(UserInterface ui, String line, SystemSolver systemSolver) throws Exception {
        Command cmd = getCmd(line);
        cmd.execute(ui, systemSolver);
    }

}
