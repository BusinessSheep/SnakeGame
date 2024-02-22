package Game;

import static Main.gamePanel.TILE_SIZE;
import static Main.gamePanel.WIDTH_IN_TILES;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import Main.gamePanel;

public class Snake {

    private Rectangle head;
    private ArrayList<Rectangle> body;
    private int x, y, size;
    private int dir = 0;
    private gamePanel panel;

    public Snake(int x, int y, int size, gamePanel panel) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.panel = panel;
        initialize();
    }

    private void initialize() {
        this.body = new ArrayList<Rectangle>();
        head = new Rectangle(this.x, this.y, this.size, this.size);
        //body.add(new Rectangle(this.x-TILE_SIZE, this.y-TILE_SIZE, this.size, this.size));
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(head.x, head.y, head.width, head.height);
        for(Rectangle r : body) {
            g.fillRect(r.x, r.y, r.width, r.height);
        }
    }

    public boolean checkAppleIntersect() {
        if(head.intersects(panel.getSnakeGame().getApple())) {
            return true;
        }
        
        return false;
    }

    public void update() {


        if(checkAppleIntersect()) {
            panel.getSnakeGame().setApplePos();
            if(body.size() == 0) {
                body.add(new Rectangle(head.x, head.y, head.width, head.height));
            } else {
                body.add(new Rectangle(body.getLast().x, body.getLast().y, body.getLast().width, body.getLast().height));
            }
            
        }

        if(body.size() > 0) {
        for(int i = body.size()-1; i >0; i--) {
            body.get(i).x = body.get(i-1).x;
            body.get(i).y = body.get(i-1).y;
        }
        body.get(0).x = head.x;
        body.get(0).y = head.y;
    }
        switch(dir) {
            case 0: // Left
            head.x -= TILE_SIZE;
            break;
            case 1: // Right
            head.x += TILE_SIZE;
            break;
            case 2: // Up
            head.y -= TILE_SIZE;
            break;
            case 3: // Down
            head.y += TILE_SIZE;
            break;
        }
        head.x = constrain(head.x, 0, (WIDTH_IN_TILES-1)*TILE_SIZE);
        head.y = constrain(head.y, 0, (WIDTH_IN_TILES-1)*TILE_SIZE);
    }

    public int constrain(int num, int lowBorder, int highBorder) {
        return Math.min(Math.max(num, lowBorder), highBorder);
    }

    /**
     * @Description 0 = left, 1 = right, 2 = up, 3 = down
     */
    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getDir() {
        return dir;
    }
    
}
