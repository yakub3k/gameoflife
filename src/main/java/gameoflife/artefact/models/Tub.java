package gameoflife.artefact.models;

import game.Artifact;

public class Tub implements Artifact {
    private final int height = 3;
    private final int width = 3;

    private final boolean[][] tub = new boolean[][]{
            {O, X, O},
            {X, O, X},
            {O, X, O},
    };

    @Override
    public String getName() {
        return "Tub";
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
        return tub;
    }
}
