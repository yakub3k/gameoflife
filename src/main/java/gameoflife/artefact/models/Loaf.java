package gameoflife.artefact.models;

import game.Artifact;

public class Loaf implements Artifact {
    private final int height = 4;
    private final int width = 4;

    private final boolean[][] loaf = new boolean[][]{
            {O, X, X, O},
            {X, O, O, X},
            {O, X, O, X},
            {O, O, X, O},
    };

    @Override
    public String getName() {
        return "Loaf";
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
        return loaf;
    }
}
