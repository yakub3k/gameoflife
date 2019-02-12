package game;

import java.io.Serializable;
import java.util.Random;

public interface Game extends Serializable {
    void switchCell(int x, int y);
    boolean isAlive(int x, int y);
    int getHeight();
    int getWidth();

    void step();
    GameState nextStep();
    GameRules getRules();
    void blackAll();
    void clearAll();
    void randomAll();
    void chessAll();

    default void blackAll(GameCell[][] all) {
        for (GameCell[] rows : all) {
            for (GameCell cell : rows) {
                cell.setAlive();
            }
        }
    }

    default void clearAll(GameCell[][] all) {
        for (GameCell[] rows : all) {
            for (GameCell cell : rows) {
                cell.setInactive();
            }
        }
    }

    default void randomAll(GameCell[][] all){
        Random random = new Random();
        for (GameCell[] rows : all) {
            for (GameCell cell : rows) {
                cell.setAlive(random.nextBoolean());
            }
        }
    }

    default void chessAll(GameCell[][] all){
        boolean chess = false;
        for (GameCell[] rows : all) {
            for (GameCell cell : rows) {
                cell.setAlive(chess);
                chess = !chess;
            }
            chess = !chess;
        }
    }
}
