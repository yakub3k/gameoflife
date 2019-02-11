package view;

import game.Game;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.util.Date;
import java.util.Timer;

import static javax.swing.GroupLayout.DEFAULT_SIZE;

public class Window extends javax.swing.JFrame {

    private static final String START_LABEL = "Start";
    private static final String STOP_LABEL = "Stop";
    private final GamePanel panel;
    private final JButton startButton;                    // start/ stop button
    private final JButton stepButton;                     // one step
    private final JButton randomButton;                   // create random cells
    private final JButton chessButton;                    // create random cells
    private final JButton clearButton;                    // clear cells
    private final JButton blackButton;                    // set all blacks
    private final JButton setArtifactButton;              // add new artifacts

    private final Game game;
    private boolean timerMode = false;
    private Timer timer;

    public Window(Game game) {
        this.game = game;
        panel = new GamePanel(game);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent ev) {
                if (!timerMode) {
                    panel.pressedInPanel(ev.getX(), ev.getY());
                }
            }
        });

        startButton = new JButton(START_LABEL);
        stepButton = new JButton("Step");
        chessButton = new JButton("Chess");
        randomButton = new JButton("Random");
        clearButton = new JButton("Clear");
        blackButton = new JButton("Black");
        setArtifactButton = new JButton("Set new");

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);

        panelLayout.setHorizontalGroup(panelLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 522, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(panelLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 249, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(createHorizontalGroup(layout));
        layout.setVerticalGroup(createVerticalGroup(layout));
        getContentPane().setLayout(layout);

        setupButtons();

        panel.setVisible(true);
        setVisible(true);
        pack();
    }

    private GroupLayout.ParallelGroup createHorizontalGroup(GroupLayout layout) {
        return layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(panel, GroupLayout.Alignment.LEADING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(clearButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(blackButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chessButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(randomButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(setArtifactButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stepButton)
                                        .addComponent(startButton)))
                        .addContainerGap());
    }


    private GroupLayout.ParallelGroup createVerticalGroup(GroupLayout layout) {
        return layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(chessButton)
                                .addComponent(clearButton)
                                .addComponent(randomButton)
                                .addComponent(startButton)
                                .addComponent(stepButton)
                                .addComponent(setArtifactButton)
                                .addComponent(blackButton))
                        .addContainerGap());
    }

    private void setupButtons() {
        startButton.addActionListener(c -> {
            timerMode = !timerMode;
            if (START_LABEL.equals(startButton.getText())) {
                startButton.setText(STOP_LABEL);
                timer = new Timer();
                timer.schedule(new GameTimer(game), new Date(), 500);
            } else {
                timer.cancel();
                startButton.setText(START_LABEL);
            }
        });
        chessButton.addActionListener(c -> {
        });
        randomButton.addActionListener(c -> game.randomAll());
        clearButton.addActionListener(c -> game.clearAll());
        blackButton.addActionListener(c -> game.blackAll());
        setArtifactButton.addActionListener(c -> {

        });
        stepButton.addActionListener(c -> game.step());
    }
}
