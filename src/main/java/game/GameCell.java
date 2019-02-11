package game;

public interface GameCell {
    void setAlive(boolean alive);

    void setAlive();

    void setInactive();

    void setOpposite();

    boolean isAlive();

    boolean isAliveInNextStep();
}
