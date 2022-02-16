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
        int size = random.nextInt(21 - 1) + 1;
        ui.displayMessage("Randomly generated matrix size: " + size);
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
