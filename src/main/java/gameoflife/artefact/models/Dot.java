package gameoflife.artefact.models;

import game.Artifact;

public class Dot implements Artifact {
    private final int height = 1;
    private final int width = 1;

    private final boolean[][] dot = new boolean[][]{{X}};

    @Override
    public String getName() {
        return "Dot";
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
        return dot;
    }
}
