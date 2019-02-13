package gameoflife;

import game.ArtifactGame;
import game.GameRules;
import gameoflife.artefact.Artifactory;
import gameoflife.board.GameBoardCreator;
import game.GameState;
import util.Log;

public class GameOfLife implements ArtifactGame {

    private final int height;
    private final int width;
    private final GameRules rules;
    private GameState currentGame;
    private Artifactory artifactory;
    private String insertModel;

    public GameOfLife(int fieldsWidth, int fieldsHeight, GameRules rules, Artifactory artifactory) {
        this.height = fieldsHeight; // y
        this.width = fieldsWidth;   // x
        this.rules = rules;
        this.currentGame = new GameBoardCreator(width, height, rules).createBaseGame();
        this.artifactory = artifactory;
        Log.log("create game width:" + width + " height:" + height);
    }

    @Override
    public void switchCell(int x, int y) {
        if (hasInsertModel()) {
            artifactory.addArtifactToGame(insertModel, this, x, y);
        } else {
            this.currentGame.switchCell(x, y);

        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        return currentGame.isAlive(x, y);
    }

    @Override
    public void setAlive(int x, int y) {
        currentGame.setAlive(x, y);
    }

    @Override
    public void setDead(int x, int y) {
        currentGame.setDead(x, y);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void blackAll() {
        currentGame.blackAll();
    }

    @Override
    public void step() {
        currentGame.step();
        currentGame = currentGame.nextStep();
    }

    @Override
    public GameState nextStep() {
        return currentGame.nextStep();
    }

    @Override
    public GameRules getRules() {
        return rules;
    }

    @Override
    public void clearAll() {
        currentGame.clearAll();
    }

    @Override
    public void randomAll() {
        currentGame.randomAll();
    }

    @Override
    public void chessAll() {
        currentGame.chessAll();
    }

    @Override
    public void setInsertModel(String insertModelName) {
        this.insertModel = insertModelName;
    }

    @Override
    public String getInsertModel() {
        return insertModel;
    }

    @Override
    public void clearInsertModel() {
        insertModel = null;
    }

    @Override
    public boolean hasInsertModel() {
        return insertModel != null;
    }

    @Override
    public Artifactory getArtifactory() {
        return artifactory;
    }
}
