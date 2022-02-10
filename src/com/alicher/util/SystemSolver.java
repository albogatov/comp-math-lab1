package com.alicher.util;

import com.alicher.models.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SystemSolver {

    public double[] solveSystem(Matrix matrix) {
        Matrix triangularMatrix = findTriangularMatrix(matrix);
        double[] solution = new double[triangularMatrix.getRows()];
        List<Integer> foundVariables = new ArrayList<Integer>();
        for (int i = triangularMatrix.getRows() - 1; i >= 0; i--) {
            int solutionNumber = -1;
            double sub = 0;
            for (int j = 0; j < triangularMatrix.getColumns() - 1; j++) {
                if (triangularMatrix.getElement(i, j) != 0 && !foundVariables.contains(j)) {
                    solutionNumber = j;
                    foundVariables.add(j);
                    break;
                }
            }
            for (int j = 0; j < triangularMatrix.getColumns() - 1; j++) {
                if (j != solutionNumber)
                    sub += triangularMatrix.getElement(i, j) * solution[j];
            }
            solution[solutionNumber] = (triangularMatrix.getElement(i, triangularMatrix.getColumns()-1) - sub)/triangularMatrix.getElement(i, solutionNumber);
        }
        return solution;
    }

    public Matrix findTriangularMatrix(Matrix matrix) {
        int currentRowsRemoved = 0;
        int initialRows = matrix.getRows();
        int initialColumns = matrix.getColumns();
        double[] maxElementData = matrix.findAbsMaxElement();
        double[][] mainElementRows = new double[matrix.getRows()][matrix.getColumns()];
        double[] sums = matrix.findMatrixSums();
        double[] multipliers = matrix.findMultipliers(maxElementData[0], (int) maxElementData[1], (int) maxElementData[2]);
        for (int i = 0; i < initialRows; i++) {
            double[] mainElementRow = matrix.getMatrixRow((int) maxElementData[1]);
            mainElementRows = fillRowIntoArray(mainElementRow, mainElementRows, currentRowsRemoved);
            matrix.modifyMatrix(multipliers, sums, mainElementRow, (int) maxElementData[1]);
            matrix.removeMatrixRow((int) maxElementData[1]);
            System.out.println("Elements of the matrix are (iter)");
            for (int a = 0; a < matrix.getRows(); a++) {
                for (int j = 0; j < matrix.getColumns(); j++)
                    System.out.print(matrix.getElement(a, j) + "  ");
                System.out.println();
            }
            maxElementData = matrix.findAbsMaxElement();
            multipliers = matrix.findMultipliers(maxElementData[0], (int) maxElementData[1], (int) maxElementData[2]);
            sums = matrix.findMatrixSums();
            currentRowsRemoved++;
        }
        Matrix triangularMatrix = new Matrix(initialRows, initialColumns);
        triangularMatrix.setElements(mainElementRows);
        System.out.println("Elements of the trio matrix are");
        for (int a = 0; a < triangularMatrix.getRows(); a++) {
            for (int j = 0; j < triangularMatrix.getColumns(); j++)
                System.out.print(triangularMatrix.getElement(a, j) + "  ");
            System.out.println();
        }
        return triangularMatrix;
    }

    public double[][] fillRowIntoArray(double[] row, double[][] array, int rowsRemoved) {
        for (int i = 0; i < row.length; i++) {
            array[rowsRemoved][i] = row[i];
        }
        return array;
    }

}

/*
3
2
-5
-1
2
-1
3
13
1
2
-1
9
 */
