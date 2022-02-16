package com.alicher.cmd;

import com.alicher.models.Matrix;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

public class SolveFromInput extends Command {

    public SolveFromInput() {
        line = "solve_from_input";
        description = "Решить СЛАУ с пользовательскими данными";
    }

    public void execute(UserInterface ui, SystemSolver systemSolver) throws Exception {
        if(ui.isInteractive())
            ui.displayMessage("Enter matrix size");
        int size = ui.readInt();
        double[][] elements = new double[size][size + 1];
        if(ui.isInteractive())
            ui.displayMessage("Enter the elements of the matrix");
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size + 1; j++)
                elements[i][j] = ui.readDouble();
        try {
            Matrix matrix = new Matrix(size, elements);
            Solve solveOp = new Solve();
            solveOp.execute(ui, systemSolver, matrix);
        } catch (IllegalArgumentException e) {
            ui.displayMessage(e.getMessage());
        }
    }
}
