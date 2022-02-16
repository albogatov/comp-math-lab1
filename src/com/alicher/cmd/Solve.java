package com.alicher.cmd;

import com.alicher.models.Matrix;
import com.alicher.models.Solution;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

public class Solve extends Command {

    public void execute(UserInterface ui, SystemSolver systemSolver, Matrix matrix) throws Exception {
        Solution solution = systemSolver.solveSystem(matrix);
        if (solution == null)
            ui.displayMessage("Determinant is zero, the system is unsolvable");
        else {
            ui.displayMessage("Determinant of the matrix is: " + solution.getDeterminant());
            ui.displayMessage("Elements of the triangular matrix are:");
            for (int i = 0; i < solution.getTriangularMatrix().getRows(); i++) {
                for (int j = 0; j < solution.getTriangularMatrix().getColumns(); j++) {
                    System.out.printf("%f", solution.getTriangularMatrix().getElement(i, j));
                    System.out.print(" ");
                }
                System.out.println();

            }
            for (int i = 0; i < solution.getVariables().length; i++) {
                int solutionNumber = i + 1;
                ui.displayMessage("x" + solutionNumber + " is " + solution.getVariables()[i]);
                ui.displayMessage("Difference for equation №" + solutionNumber + " is: " + solution.getDifferences()[i]);
            }
        }
    }

    @Override
    public void execute(UserInterface ui, SystemSolver systemSolver) throws Exception {

    }
}
