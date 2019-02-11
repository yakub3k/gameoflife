import game.Game;
import game.GameRules;
import gameoflife.rules.ConwayRulesInfinity;
import gameoflife.GameOfLife;
import gameoflife.rules.ConwayRulesWall;
import view.Window;

public class Runner {

    public static void main(String[] args) {
//        GameRules conway = new ConwayRulesInfinity();
        GameRules conwayWall = new ConwayRulesWall();
        Game game = new GameOfLife(120, 60, conwayWall);
        Window win = new Window(game);
        win.setVisible(true);
    }
}
