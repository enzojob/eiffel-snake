package address.presentation;

import java.util.ArrayList;

import address.SnakeApp;
import address.model.Snake;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Field extends Pane {

    private int width, height;

    ArrayList<Block> blocks = new ArrayList<>();

    int score = 0;
    Food food;
    Snake snake;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;

        setMinSize(this.width * SnakeApp.getBlockSize(), this.height * SnakeApp.getBlockSize());
        setBackground(new Background(new BackgroundFill(Color.AZURE, null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        addFood();
    }

    public void addSnake(Snake snake) {
        this.snake = snake;
        for (Block block : snake.blocks) {
            addBlock(block);
        }
    }

    public void update() {
        for (Block block : blocks) {
            block.update();
        }

        if (isEaten(food)) {
            score += 20;
            addFood();
            addNewBlock();
        }
    }

    public boolean isDead() {
        for (Block block : blocks) {
            if (block != snake.head) {
                if (block.posX == snake.head.posX && block.posY == snake.head.posY) {
                    blocks.clear();
                    return true;
                }
            }
        }
        return false;
    }

    public void addNewBlock() {
        Block block = new Block(snake.tail.oldPosX, snake.tail.oldPosY, snake.tail, this);
        snake.tail = block;
        addBlock(block);
    }

    private void addBlock(Block block) {
        getChildren().add(block);
        blocks.add(block);
        block.setFill(Color.color(Math.random(), Math.random(), Math.random()));
    }

    public void addFood() {
        int randomX = (int) (Math.random() * width);
        int randomY = (int) (Math.random() * height);

        Food food = new Food(randomX, randomY);

        getChildren().add(food);
        getChildren().remove(this.food);
        this.food = food;
    }

    public boolean isEaten(Food food) {
        if (food == null) {
            return false;
        }
        return food.getPosX() == snake.head.posX && food.getPosY() == snake.head.posY;
    }

    public int getW() {
        return width;
    }

    public int getH() {
        return height;
    }
}
