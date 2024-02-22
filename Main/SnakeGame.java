package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Game.Snake;
import static Main.gamePanel.TILE_SIZE;
import static Main.gamePanel.WIDTH_IN_TILES;

public class SnakeGame implements Runnable{

    private final int FPS = 10;
    private gamePanel panel;
    private Thread gameThread;
    private Snake snake;
    private Rectangle apple;

    public SnakeGame() {
        
        panel = new gamePanel(this);
        new gameFrame(panel);
        initialize();
        panel.setFocusable(true);
        panel.requestFocus();
        panel.setBackground(Color.black);
        
        startGame();
    }

    private void startGame() {
       gameThread = new Thread(this);
       gameThread.start();
    }
    
    private void initialize() {
        snake = new Snake(WIDTH_IN_TILES/2 * TILE_SIZE, WIDTH_IN_TILES/2 * TILE_SIZE, TILE_SIZE, panel);
        setApplePos();
    }

    private int randomNum(int low, int high) {
        return (int) (Math.random() * (high - low + 1) - low);
    }

    public void setApplePos() {
        apple = new Rectangle(randomNum(0, WIDTH_IN_TILES-1) * TILE_SIZE, randomNum(0, WIDTH_IN_TILES-1) * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    public void draw(Graphics g) {
        snake.draw(g);
        g.setColor(Color.red);
        g.fillRect(apple.x, apple.y, apple.width, apple.height);
    }

    private void update() {
       snake.update();
    }

    public Snake getSnake() {
        return snake;
    }

    public Rectangle getApple() {
        return apple;
    }

    @Override
	public void run() {
		double frameTime = 1000000000.0 / FPS;

        long lastTime = System.nanoTime();

        double timeSinceLastFrame = 0;

        while (true) {
            long currentTime = System.nanoTime();

            timeSinceLastFrame += (currentTime - lastTime) / frameTime;
            lastTime = currentTime;
            if (timeSinceLastFrame >= 1) { 
            	update();
                panel.repaint();
                timeSinceLastFrame--; // Don't set to 0 as a means of catching up if frames are lost
            }
        }
	}
}
