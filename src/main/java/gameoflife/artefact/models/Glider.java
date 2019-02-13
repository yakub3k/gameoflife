package gameoflife.artefact.models;

import game.Artifact;

public class Glider implements Artifact {
    private final int height = 3;
    private final int width = 3;

    private final boolean[][] gilder = new boolean[][]{
            {O, X, O},
            {O, O, X},
            {X, X, X},
    };

    @Override
    public String getName() {
        return "Glider";
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
        return gilder;
    }
}
