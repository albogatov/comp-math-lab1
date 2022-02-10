package com.alicher.models;

public class Matrix {

    private double[][] elements;

    private int rows;

    private int columns;

    public Matrix(int rows, int columns) {

        if (rows <= 0 || columns <= 0)
            throw new IllegalArgumentException("Неправильные измерения матрицы");

        this.rows = rows;
        this.columns = columns;
        this.elements = new double[rows][columns];

    }

    public double[] findAbsMaxElement() {
        double maxElementData[] = new double[3];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 1; j++)
                if (Math.abs(elements[i][j]) > Math.abs(maxElementData[0])) {
                    maxElementData[0] = elements[i][j];
                    maxElementData[1] = i;
                    maxElementData[2] = j;
                }
        }
        return maxElementData;
    }

    public double[] getMatrixRow(int row) {
        double[] rowElements = new double[columns];
        for (int i = 0; i < columns; i++) {
            rowElements[i] = elements[row][i];
        }
        return rowElements;
    }

    public double findRowSum(int row) {
        double sum = 0;
        for (int i = 0; i < columns; i++) {
            sum += elements[row][i];
        }
        return sum;
    }

    public double[] findMatrixSums() {
        double[] sums = new double[rows];
        for (int i = 0; i < rows; i++) {
            sums[i] = findRowSum(i);
        }
        return sums;
    }

    public double[] findMultipliers(double maxElement, int mainElementRow, int mainElementColumn) {
        double[] multipliers = new double[rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                multipliers[i] = -1 * elements[i][mainElementColumn] / maxElement;
            }
        }
        return multipliers;
    }

    public void modifyMatrix(double[] multipliers, double[] sums, double[] mainElementRow, int mainElementRowIdx) {
        double[] newSums = new double[rows];
        //double[] mainElementCoefficients = elements[mainElementRow];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            //while (true) {
                //count++;
                //if (count > 10)
                //   break;
                System.out.println(Math.abs(newSums[i] - sums[i]));
                for (int j = 0; j < columns; j++) {
                    elements[i][j] = elements[i][j] + mainElementRow[j] * multipliers[i];
                    newSums[i] = findRowSum(i);
                }
                //if (mainElementRowIdx == i || Math.abs(newSums[i] - sums[i]) < 0.00001)
                //    break;
            //}
        }
        System.out.println(elements);
    }

    public void removeMatrixRow(int row) {
        for (int i = row; i < rows - 1; i++) {
            for (int j = 0; j < columns; j++) {
                elements[i][j] = elements[i + 1][j];
            }
        }
        rows = rows - 1;
        System.out.println(elements);
    }

    public void setElements(double[][] elements) {
        this.elements = elements;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public double[][] getElements() {
        return elements;
    }

    public double getElement(int i, int j) {
        return this.elements[i][j];
    }
}

