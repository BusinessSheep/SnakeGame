package Main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Inputs.KeyInputs;

public class gamePanel extends JPanel{
    private SnakeGame snakeGame;
    
    public gamePanel(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        setFocusable(true);
        setPreferredSize(new Dimension(600, 600));
        addKeyListener(new KeyInputs(this));
    }

    public SnakeGame getSnakeGame() {
        return snakeGame;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snakeGame.draw(g);
    }

}
