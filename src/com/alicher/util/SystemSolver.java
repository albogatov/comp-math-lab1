package com.alicher.util;

import com.alicher.models.Matrix;
import com.alicher.models.Solution;

import java.util.ArrayList;
import java.util.List;

public class SystemSolver {

    public Solution solveSystem(Matrix matrix) {
        Matrix initialMatrix = new Matrix(matrix.getRows(), matrix.getElements());
        Matrix triangularMatrix = findTriangularMatrix(matrix);
        double det = triangularMatrix.findDiagonalMatrixDet();
        if (det == 0)
            return null;
        double[] variables = new double[triangularMatrix.getRows()];
        //List<Integer> foundVariables = new ArrayList<Integer>();
        for (int i = triangularMatrix.getRows() - 1; i >= 0; i--) {
            int solutionNumber = i;
            double sub = 0;
            /*
            for (int j = 0; j < triangularMatrix.getColumns() - 1; j++) {
                if (triangularMatrix.getElement(i, j) != 0 && !foundVariables.contains(j)) {
                    solutionNumber = j;
                    //foundVariables.add(j);
                    break;
                }
            }
             */
            for (int j = 0; j < triangularMatrix.getColumns() - 1; j++) {
                if (j != solutionNumber)
                    sub += triangularMatrix.getElement(i, j) * variables[j];
            }
            variables[solutionNumber] = (triangularMatrix.getElement(i, triangularMatrix.getColumns()-1) - sub)/triangularMatrix.getElement(i, solutionNumber);
        }
        //variables[triangularMatrix.getRows()] = det;
        double[] differences = findDifferences(initialMatrix, variables);
        Solution solution = new Solution(triangularMatrix, variables, det, differences);
        return solution;
    }

    public Matrix findTriangularMatrix(Matrix matrix) {
        int currentRowsRemoved = 0;
        int initialRows = matrix.getRows();
        int initialColumns = matrix.getColumns();
        double[][] mainElementRows = new double[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < initialRows; i++) {
            double[] maxElementData = matrix.findColumnAbsMaxElement(i);
            //double[] maxElementData = matrix.findAbsMaxElement();
            double[] sums = matrix.findMatrixSums();
            double[] multipliers = matrix.findMultipliers(maxElementData[0], (int) maxElementData[1], (int) maxElementData[2]);
            double[] mainElementRow = matrix.getMatrixRow((int) maxElementData[1]);
            mainElementRows = fillRowIntoArray(mainElementRow, mainElementRows, currentRowsRemoved);
            matrix.modifyMatrix(multipliers, sums, mainElementRow, (int) maxElementData[1]);
            matrix.removeMatrixRow((int) maxElementData[1]);
            //maxElementData = matrix.findAbsMaxElement();
            //multipliers = matrix.findMultipliers(maxElementData[0], (int) maxElementData[1], (int) maxElementData[2]);
            //sums = matrix.findMatrixSums();
            currentRowsRemoved++;
        }
        Matrix triangularMatrix = new Matrix(initialRows, initialColumns);
        triangularMatrix.setElements(mainElementRows);
        //sortTriangularMatrix(triangularMatrix);
        return triangularMatrix;
    }

    public double[][] fillRowIntoArray(double[] row, double[][] array, int rowsRemoved) {
        for (int i = 0; i < row.length; i++) {
            array[rowsRemoved][i] = row[i];
        }
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

    /*
    public Matrix sortTriangularMatrix(Matrix matrix) {
        for (int j = 0; j < matrix.getColumns() - 1; j++) {
            int zeroCount = 0;
            for (int i = 0; i < matrix.getRows(); i++) {
                if (matrix.getElement(i,j) == 0)
                    zeroCount++;
            }
            if (matrix.getRows() - 1 - j < zeroCount) {
                matrix.swapColumns(j, j-1);
            }
        }
        return matrix;
    }
     */

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
/*
3
4
-9
5
-14
-15
-12
50
-16
44
-27
-36
73
8
142
9
12
-10
-16
-76
 */
