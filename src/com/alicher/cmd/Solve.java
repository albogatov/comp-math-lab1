package com.alicher.cmd;

import com.alicher.models.Matrix;
import com.alicher.models.Solution;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

import java.util.concurrent.TimeUnit;

public class Solve extends Command {

    public void execute(UserInterface ui, SystemSolver systemSolver, Matrix matrix) throws Exception {
        ui.displayMessage("Initial matrix of the system is: ");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                ui.displayMessageNoNL(String.format(" %7.3f ", matrix.getElement(i,j)));
            }
            ui.displayMessage("");
        }
        long start = System.nanoTime();
        Solution solution = systemSolver.solveSystem(matrix);
        long end = System.nanoTime();
        if (solution == null)
            ui.displayMessage("Determinant is zero, the system is unsolvable");
        else {
            ui.displayMessage("Determinant of the matrix is: " + solution.getDeterminant());
            ui.displayMessage("Elements of the triangular matrix are:");
            for (int i = 0; i < solution.getTriangularMatrix().getRows(); i++) {
                for (int j = 0; j < solution.getTriangularMatrix().getColumns(); j++) {
                    ui.displayMessageNoNL(String.format(" %7.3f ", solution.getTriangularMatrix().getElement(i,j)));
                }
                ui.displayMessage("");

            }
            for (int i = 0; i < solution.getVariables().length; i++) {
                int solutionNumber = i + 1;
                ui.displayMessage(String.format("x" + solutionNumber + " is %5.3f ", solution.getVariables()[i]));
                ui.displayMessage("Difference for equation №" + solutionNumber + " is: " + solution.getDifferences()[i]);
            }
        }
        ui.displayMessage("System solved in: " + (end - start) + "ns");
    }

    @Override
    public void execute(UserInterface ui, SystemSolver systemSolver) {

    }
}
