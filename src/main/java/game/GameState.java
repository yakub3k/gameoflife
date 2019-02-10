package game;

public interface GameState extends Game {
    void setNextState(GameState next);

    void setDimens(int width, int height);
}
