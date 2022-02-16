package com.alicher;

import com.alicher.cmd.Command;
import com.alicher.cmd.SolveFromInput;
import com.alicher.models.Matrix;
import com.alicher.util.CommandCenter;
import com.alicher.util.SystemSolver;
import com.alicher.util.UserInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] arg) {
        try {
            UserInterface userInteraction = new UserInterface(new InputStreamReader(System.in), new OutputStreamWriter(System.out), true);
            userInteraction.displayMessage("Hello! Please enter one of the following commands:\n" +
                    "solve_from_input - solve a system based on a matrix of your choice\n" +
                    "solve_from_file - solve a system based on a matrix from a chosen file\n" +
                    "solve_random - solve a system based on a randomly generated matrix");
            while (true) {
                try {
                    SystemSolver systemSolver = new SystemSolver();
                    String line;
                    do {
                        line = userInteraction.read().trim();
                        String cmd = line.split(" ")[0];
                        CommandCenter.getInstance().executeCommand(userInteraction, cmd, systemSolver);
                    } while (userInteraction.hasNextLine());
                } catch (NullPointerException e) {
                    userInteraction.displayMessage("Could not recognize command, try again");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
