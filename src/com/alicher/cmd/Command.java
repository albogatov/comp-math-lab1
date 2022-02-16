package com.alicher.cmd;

import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

public abstract class Command {

    public String line;

    public String description;

    /**
     * Метод исполнения команды.
     *  @param ui                 объект, через который ведется взаимодействие с пользователем.
     */
    public abstract void execute(UserInterface ui, SystemSolver systemSolver) throws Exception;

    /**
     * Возвращает строку, вызывающую команду.
     *
     * @return Строка вызова команды.
     */
    public String getCommand() {
        return line;
    }

    /**
     * Возвращает описание команды.
     *
     * @return Описание команды.
     */
    public String getHelp() {
        return description;
    }

}
