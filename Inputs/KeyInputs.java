package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.gamePanel;

public class KeyInputs implements KeyListener{

    private gamePanel panel;

    public KeyInputs(gamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
       switch(e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        if(panel.getSnakeGame().getSnake().getDir() != 1) {
        panel.getSnakeGame().getSnake().setDir(0);
        }
        break;
        case KeyEvent.VK_RIGHT:
        if(panel.getSnakeGame().getSnake().getDir() != 0) {
        panel.getSnakeGame().getSnake().setDir(1);
        }
        break;
        case KeyEvent.VK_UP:
        if(panel.getSnakeGame().getSnake().getDir() != 3) {
        panel.getSnakeGame().getSnake().setDir(2);
        }
        break;
        case KeyEvent.VK_DOWN:
        if(panel.getSnakeGame().getSnake().getDir() != 2) {
        panel.getSnakeGame().getSnake().setDir(3);
        }
        break;
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
