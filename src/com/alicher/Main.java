package com.alicher;

import com.alicher.models.Matrix;
import com.alicher.util.SystemSolver;

import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {
        int m, n, i, j;
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            System.out.println("Enter the number "
                    + "of rows of the matrix");
            m = in.nextInt();
            System.out.println("Enter the number "
                    + "of columns of the matrix");
            n = in.nextInt();

            // Declare the matrix
            double first[][] = new double[m][n];

            // Read the matrix values
            System.out.println("Enter the elements of the matrix");
            for (i = 0; i < m; i++)
                for (j = 0; j < n; j++)
                    first[i][j] = in.nextDouble();

            // Display the elements of the matrix
            System.out.println("Elements of the matrix are");
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++)
                    System.out.print(first[i][j] + "  ");
                System.out.println();
            }
            Matrix matrix = new Matrix(m, n);
            Matrix initialMatrix = new Matrix(m,n);
            matrix.setElements(first);
            initialMatrix.setElements(first);
            SystemSolver systemSolver = new SystemSolver();
            double[] solution = systemSolver.solveSystem(matrix);
            double[] differences = systemSolver.findDifferences(initialMatrix, solution);
            for(int u = 0; u < solution.length - 1; u++)
                System.out.println(solution[u]);
            System.out.println(solution[solution.length - 1]);
            for(int u = 0; u < differences.length; u++)
                System.out.println(differences[u]);
            System.out.println("Done");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            in.close();
        }
    }
}
