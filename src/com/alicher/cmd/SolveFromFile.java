package com.alicher.cmd;

import com.alicher.models.Matrix;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

public class SolveFromFile extends Command {

    public SolveFromFile() {
        line = "solve_from_file";
        description = "Решить СЛАУ, взяв данные из файла";
    }

    public void execute(UserInterface ui, String[] arguments, SystemSolver systemSolver) throws Exception {
        /*
        Matrix matrix;
        Matrix initialMatrix;
        double[] solution = systemSolver.solveSystem(matrix);
        double[] differences = systemSolver.findDifferences(initialMatrix, solution);
         */
    }
}
