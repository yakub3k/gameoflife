package gameoflife.artefact.models;

import game.Artifact;

public class Pentomino implements Artifact {
    private final int height = 3;
    private final int width = 3;

    private final boolean[][] pentomino = new boolean[][]{
            {O, X, X},
            {X, X, O},
            {O, X, O},
    };

    @Override
    public String getName() {
        return "Pentomino";
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public boolean[][] getMatrix() {
        return pentomino;
    }
}
