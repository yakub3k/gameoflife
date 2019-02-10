import game.Game;
import game.GameRules;
import gameoflife.ConwayRulesInfinity;
import gameoflife.GameOfLife;
import view.Window;

public class Runner {

    public static void main(String[] args) {
        GameRules conway = new ConwayRulesInfinity();
        Game game = new GameOfLife(120, 60, conway);
        Window win = new Window(game);
        win.setVisible(true);
    }
}
