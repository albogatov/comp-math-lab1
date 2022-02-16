package com.alicher.cmd;

import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class SolveFromFile extends Command {

    public SolveFromFile() {
        line = "solve_from_file";
        description = "Решить СЛАУ, взяв данные из файла";
    }

    public void execute(UserInterface ui, SystemSolver systemSolver) throws Exception {
        String filePath;
        ui.displayMessage("Enter file path");
        while (true) {
            try {
                filePath = ui.read();
                UserInterface fileInteraction = new UserInterface(new FileReader(filePath), new OutputStreamWriter(System.out), false);
                SolveFromInput solveFromInputOp = new SolveFromInput();
                solveFromInputOp.execute(fileInteraction, systemSolver);
                break;
            } catch (FileNotFoundException e) {
                ui.displayMessage("File not found, try again");
            }
        }
    }
}
