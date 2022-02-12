package com.alicher.cmd;

import com.alicher.models.Matrix;
import com.alicher.models.Solution;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

public class SolveFromInput extends Command {

    public String line = "solve_from_input";

    public String description = "Решить СЛАУ с пользовательскими данными";

    public void execute(UserInterface ui, String[] arguments, SystemSolver systemSolver) throws Exception {
        Matrix matrix;
        //Matrix initialMatrix;
        ui.displayMessage("Enter matrix size");
        int size = ui.readInt();
        double[][] elements = new double[size][size+1];
        ui.displayMessage("Enter the elements of the matrix");
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size + 1; j++)
                elements[i][j] = ui.readDouble();
        matrix = new Matrix(size, elements);
        //initialMatrix = new Matrix(size, elements);
        Solution solution = systemSolver.solveSystem(matrix);
        //double[] differences = systemSolver.findDifferences(initialMatrix, solution);
        if (solution == null)
            ui.displayMessage("Determinant is zero, the system is unsolvable");
        else {
            ui.displayMessage("Determinant of the matrix is: " + solution.getDeterminant());
            ui.displayMessage("Elements of the triangular matrix are:");
            for (int i = 0; i < solution.getTriangularMatrix().getRows(); i++) {
                for (int j = 0; j < solution.getTriangularMatrix().getColumns(); j++)
                    System.out.print(solution.getTriangularMatrix().getElement(i,j) + " ");
                System.out.println();

            }
            for (int i = 0; i < solution.getVariables().length; i++) {
                int solutionNumber = i + 1;
                ui.displayMessage("x" + solutionNumber + " is " + solution.getVariables()[i]);
                ui.displayMessage("Difference for equation №" + solutionNumber + " is: " + solution.getDifferences()[i]);
            }
        }
    }
}
