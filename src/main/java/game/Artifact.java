package game;

public interface Artifact {
    boolean O = false;
    boolean X = true;

    String getName();
    int getHeight();
    int getWidth();
    boolean[][] getMatrix();

}
