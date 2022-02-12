package com.alicher.cmd;

import com.alicher.models.Matrix;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

public class SolveRandom extends Command {
    public String line = "solve_random";

    public String description = "Решить случайным образом сгенерированную СЛАУ";

    public void execute(UserInterface ui, String[] arguments, SystemSolver systemSolver) throws Exception {
        /*
        Matrix matrix;
        Matrix initialMatrix;
        double[] solution = systemSolver.solveSystem(matrix);
        double[] differences = systemSolver.findDifferences(initialMatrix, solution);
         */
    }
}
