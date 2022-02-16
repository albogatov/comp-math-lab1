package com.alicher.models;

public class Solution {
    private final Matrix triangularMatrix;
    private final double[] variables;
    private final double determinant;
    private final double[] differences;

    public Solution(Matrix triangularMatrix, double[] variables, double determinant, double[] differences) {
            this.triangularMatrix = triangularMatrix;
            this.variables = variables;
            this.determinant = determinant;
            this.differences = differences;
    }

    public Matrix getTriangularMatrix() {
        return triangularMatrix;
    }

    public double[] getVariables() {
        return variables;
    }

    public double getDeterminant() {
        return determinant;
    }

    public double[] getDifferences() {
        return differences;
    }
}
