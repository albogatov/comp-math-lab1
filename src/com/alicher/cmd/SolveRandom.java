package com.alicher.cmd;

import com.alicher.models.Matrix;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

import java.util.Random;

public class SolveRandom extends Command {

    public SolveRandom() {
        line = "solve_random";
        description = "Решить случайным образом сгенерированную СЛАУ";
    }

    public void execute(UserInterface ui, SystemSolver systemSolver) throws Exception {
        Random random = new Random();
        int size = -1;
        ui.displayMessage("Matrix of what size would you like to generate? (Choose between 1 and 20)");
        while (size < 1 || size > 20) {
            ui.displayMessage("Please, enter a number between 1 and 20");
            size = ui.readInt();
        }
        ui.read();
        //ui.displayMessage("Randomly generated matrix size: " + size);
        double[][] elements = new double[size][size + 1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                int scale = random.nextInt(100);
                elements[i][j] = random.nextDouble()*scale;
            }
        }
        try {
            Matrix matrix = new Matrix(size, elements);
            Solve solveOp = new Solve();
            solveOp.execute(ui, systemSolver, matrix);
        } catch (IllegalArgumentException e) {
            ui.displayMessage(e.getMessage());
        }
    }
}
