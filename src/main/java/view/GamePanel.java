package view;

import game.Game;
import util.Log;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final int GRID_LEN = 10;

    private final Game game;
    private final int gameHeight;
    private final int gameWidth;

    GamePanel(Game game) {
        this.game = game;
        this.gameHeight = game.getHeight();
        this.gameWidth = game.getWidth();
        int heightDimens = gameHeight * GRID_LEN;
        int widthDimens = gameWidth * GRID_LEN;
        Log.log("create game panel: " + widthDimens + " / " + heightDimens);
        setPreferredSize(new Dimension(widthDimens, heightDimens));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        g.setColor(Color.WHITE);

        drawCells(graphics);
        drawGrid(graphics);

        repaint();
    }

    void pressedInPanel(int height, int width) {
        int x = height / GRID_LEN;
        int y = width / GRID_LEN;
        game.switchCell(x, y);

        Log.log("press x:" + x + " y:" + y);
    }

    private void drawCells(Graphics2D graphics) {
        for (int x = 0; x < gameWidth; x++) {
            for (int y = 0; y < gameHeight; y++) {
                if (game.isAlive(x, y)) {
                    graphics.setColor(Color.BLACK);
                } else {
                    graphics.setColor(Color.WHITE);
                }

                graphics.fillRect(x * GRID_LEN, y * GRID_LEN, GRID_LEN, GRID_LEN);

            }
        }
    }

    private void drawGrid(Graphics2D graphics) {
        graphics.setColor(Color.lightGray);
        for (int i = 0; i < getWidth(); i += GRID_LEN) {
            graphics.drawLine(i, 0, i, getHeight());
        }
        for (int i = 0; i < getHeight(); i += GRID_LEN) {
            graphics.drawLine(0, i, getWidth(), i);
        }
    }
}
