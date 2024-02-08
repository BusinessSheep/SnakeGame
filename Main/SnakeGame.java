package Main;

import java.awt.Color;
import java.awt.Graphics;

import Game.Snake;

public class SnakeGame implements Runnable{

    private final int FPS = 60;
    private gamePanel panel;
    private Thread gameThread;
    private Snake snake;

    public SnakeGame() {
        panel = new gamePanel(this);
        new gameFrame(panel);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.setBackground(Color.black);
        startGame();
    }

    private void startGame() {
       gameThread = new Thread(this);
       gameThread.start();
    }

    public void draw(Graphics g) {
        
    }

    private void update() {
       
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
