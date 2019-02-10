package game;

public interface GameCell {
    void setAlive(boolean alive);

    void setAlive();

    void setInactive();

    void setOpposite();

    boolean checkNeighbours();

    boolean isAlive();

    boolean isAliveInNextStep();
}
