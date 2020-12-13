package address.presentation;

import address.SnakeApp;
import javafx.scene.shape.Rectangle;

/*
 * This class contains the block attributes and methods. The constructor inherits from the Rectangle class, and calls the block sizes of the snake defined in SnakeApp.
 * It manages the movement, direction and display of the snake.
 * */
public class Block extends Rectangle {

    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    int posX, posY, oldPosX, oldPosY;
    Block previousBlock;
    public int direction = LEFT;
    int maxX, maxY;

    public Block(int x, int y, Block previousBlock, Field field) {
        super(SnakeApp.getBlockSize(), SnakeApp.getBlockSize());
        posX = x;
        posY = y;

        // Arguments for setTranslate are pixels - multiplication by blockSize to display correctly
        setTranslateX(posX * SnakeApp.getBlockSize());
        setTranslateY(posY * SnakeApp.getBlockSize());

        this.previousBlock = previousBlock;

        maxX = field.getW();
        maxY = field.getH();
    }

    public void update() {
        oldPosX = posX;
        oldPosY = posY;

        if (previousBlock == null) {
            switch (direction) {
                case UP:
                    moveUp();
                    break;
                case RIGHT:
                    moveRight();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case LEFT:
                    moveLeft();
                    break;
            }
        } else {
            posX = previousBlock.oldPosX;
            posY = previousBlock.oldPosY;
        }
        updatePosition(); // update visual representation
    }

    public void moveUp() {
        posY--;
        if (posY < 0) {
            posY = maxY - 1;
        }
    }

    public void moveDown() {
        posY++;
        if (posY >= maxY) {
            posY = 0;
        }
    }

    public void moveLeft() {
        posX--;
        if (posX < 0) {
            posX = maxX - 1;
        }
    }

    public void moveRight() {
        posX++;
        if (posX >= maxX) {
            posX = 0;
        }
    }

    // apply the movements
    public void updatePosition() {
        setTranslateX(posX * SnakeApp.getBlockSize());
        setTranslateY(posY * SnakeApp.getBlockSize());
    }
}
