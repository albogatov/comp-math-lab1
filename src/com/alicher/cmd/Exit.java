package com.alicher.cmd;

import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

public class Exit extends Command{

    public Exit() {
        line = "exit";
        description = "Выход";
    }

    @Override
    public void execute(UserInterface ui, SystemSolver systemSolver) throws Exception {
        ui.displayMessage("Byeeeeeeeeeee!");
        System.exit(0);
    }
}
