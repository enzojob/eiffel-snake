package address;

import address.model.Snake;
import address.presentation.Field;
import address.presentation.Main_UI;

/*
 * Snake App with global parameters calling the initial constructors
 * */
public class SnakeApp {

    private static final int blockSize = 30; // size of a block
    private static final int width = 25; // multiplied by blockSize in Field constructor
    private static final int height = 20; // ^
    private static Snake snake;
    private static Field field;

    @SuppressWarnings("static-access")
    public static void main(String[] args) {

        field = new Field(width, height);
        snake = new Snake(Snake.getInitialSnakeLength(), field);
        field.addSnake(snake);
        new Main_UI().main(args);

    }

    public static int getBlockSize() {
        return blockSize;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static Snake getSnake() {
        return snake;
    }

    public static Field getField() {
        return field;
    }

}
