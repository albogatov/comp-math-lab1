package com.alicher.cmd;

import com.alicher.models.Matrix;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

public abstract class Command {

    public String line;

    public String description;

    //public abstract String execute();
    /**
     * Метод исполнения команды.
     *  @param ui                 объект, через который ведется взаимодействие с пользователем.
     * @param arguments          необходимые для исполнения аргументы.
     * @param systemSolver
     */
    public abstract void execute(UserInterface ui, String[] arguments, SystemSolver systemSolver) throws Exception;

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
