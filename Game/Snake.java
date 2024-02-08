package Game;

import java.util.ArrayList;

public class Snake {
    private class bodySegment {
        int x;
        int y;
        int size = 30;
        
        public bodySegment(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private ArrayList<bodySegment> snakeBody;
    public Snake() {
    }
    
}
