package Main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Inputs.KeyInputs;

public class gamePanel extends JPanel{
    private SnakeGame snakeGame;
    public static final int TILE_SIZE = 20;
    public static final int WIDTH_IN_TILES = 30;
    private static int WINDOW_SIZE = TILE_SIZE * WIDTH_IN_TILES;
    
    public gamePanel(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        setFocusable(true);
        setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
        addKeyListener(new KeyInputs(this));
    }

    public SnakeGame getSnakeGame() {
        return snakeGame;
    }

    public int getTileSize() {
        return TILE_SIZE;
    }

    public int getWidthInTiles() {
        return WIDTH_IN_TILES;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snakeGame.draw(g);
    }

}
