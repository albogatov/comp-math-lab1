package com.alicher.models;

public class EquationSystem {

    private Matrix extendedModifiedMatrix;

    private int size;

    public EquationSystem(Matrix matrix, int size) {
        if(size < 1 || size > 20)
            throw new IllegalArgumentException("Слишком большая система или входные данные неверны");
        this.extendedModifiedMatrix = matrix;
        this.size = size;
    }
}
