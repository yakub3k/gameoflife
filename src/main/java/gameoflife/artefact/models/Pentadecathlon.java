package gameoflife.artefact.models;

import game.Artifact;

public class Pentadecathlon implements Artifact {
    private final int height = 6;
    private final int width = 3;

    private final boolean[][] pentadecathlon = new boolean[][]{
            {X, X, X},
            {X, O, X},
            {X, X, X},
            {X, X, X},
            {X, O, X},
            {X, X, X},

    };

    @Override
    public String getName() {
        return "Pentadecathlon (period 15)";
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
        return pentadecathlon;
    }
}
