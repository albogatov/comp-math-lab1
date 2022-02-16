package com.alicher.util;

import com.alicher.models.Matrix;
import com.alicher.models.Solution;

public class SystemSolver {

    public Solution solveSystem(Matrix matrix) {
        Matrix initialMatrix = new Matrix(matrix.getRows(), matrix.getElements());
        Matrix triangularMatrix = findTriangularMatrix(matrix);
        double det = triangularMatrix.findDiagonalMatrixDet();
        if (det == 0)
            return null;
        double[] variables = new double[triangularMatrix.getRows()];
        for (int i = triangularMatrix.getRows() - 1; i >= 0; i--) {
            double sub = 0;
            for (int j = 0; j < triangularMatrix.getColumns() - 1; j++) {
                if (j != i)
                    sub += triangularMatrix.getElement(i, j) * variables[j];
            }
            variables[i] = (triangularMatrix.getElement(i, triangularMatrix.getColumns()-1) - sub)/triangularMatrix.getElement(i, i);
        }
        double[] differences = findDifferences(initialMatrix, variables);
        return new Solution(triangularMatrix, variables, det, differences);
    }

    public Matrix findTriangularMatrix(Matrix matrix) {
        int currentRowsRemoved = 0;
        int initialRows = matrix.getRows();
        int initialColumns = matrix.getColumns();
        double[][] mainElementRows = new double[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < initialRows; i++) {
            double[] maxElementData = matrix.findColumnAbsMaxElement(i);
            double[] multipliers = matrix.findMultipliers(maxElementData[0], (int) maxElementData[2]);
            double[] mainElementRow = matrix.getMatrixRow((int) maxElementData[1]);
            mainElementRows = fillRowIntoArray(mainElementRow, mainElementRows, currentRowsRemoved);
            matrix.modifyMatrix(multipliers, mainElementRow);
            matrix.removeMatrixRow((int) maxElementData[1]);
            currentRowsRemoved++;
        }
        Matrix triangularMatrix = new Matrix(initialRows, initialColumns);
        triangularMatrix.setElements(mainElementRows);
        return triangularMatrix;
    }

    public double[][] fillRowIntoArray(double[] row, double[][] array, int rowsRemoved) {
        System.arraycopy(row, 0, array[rowsRemoved], 0, row.length);
        return array;
    }

    public double[] findDifferences(Matrix matrix, double[] solution) {
        double[] differences = new double[matrix.getRows()];
        for (int i = 0; i < matrix.getRows(); i++) {
            double leftPart = 0;
            for (int j = 0; j < matrix.getColumns() - 1; j++) {
                leftPart += matrix.getElement(i, j)*solution[j];
            }
            differences[i] = Math.abs(leftPart - matrix.getElement(i, matrix.getColumns() - 1));
        }
        return differences;
    }

}