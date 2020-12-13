package address.model;

import address.SnakeApp;
import address.presentation.Block;
import address.presentation.Field;

import java.util.ArrayList;

/*
 * This is the snake class, with a constructor that generates a snake in the middle of the field.
 * The direction methods call the block class
 * */

public class Snake {

    public ArrayList<Block> blocks = new ArrayList<>();

    public static int initialSnakeLength = 5;

    private Block head;
    private Block tail;

    public Snake(int initialSnakeLength, Field field) {

        int initialPositionX = field.getW() / 2;
        int initialPositionY = field.getH() / 2;

        head = new Block(initialPositionX, initialPositionY, null, field);
        blocks.add(head);

        head.setArcHeight(SnakeApp.getBlockSize() / 2.0);
        head.setArcWidth(SnakeApp.getBlockSize() / 2.0);

        tail = head;

        for (int i = 1; i < initialSnakeLength; i++) {
            Block block = new Block(initialPositionX + i, initialPositionY, tail, field);
            blocks.add(block);
            tail = block;
        }

    }

    public Block getHead() {
        return head;
    }

    public Block getTail() {
        return tail;
    }

    public void setTail(Block tail) {
        this.tail = tail;
    }

    public int getDirection() {
        return head.direction;
    }

    public static int getInitialSnakeLength() {
        return initialSnakeLength;
    }

    public void setDirection(int direction) {
        head.direction = direction;
    }
}
