package address.model;

import address.SnakeApp;
import address.presentation.Block;
import address.presentation.Field;

import java.util.ArrayList;

public class Snake {

	public ArrayList<Block> blocks = new ArrayList<>();

	public static int intitalSnakeLength = 5;

	public Block head;
	public Block tail;

	public Snake(int initialSnakeLength, Field field) {
		int initialPositionX = field.getW() / 2;
		int initialPositionY = field.getH() / 2;

		head = new Block(initialPositionX, initialPositionY, null, field);
		blocks.add(head);

		head.setArcHeight(SnakeApp.getBlockSize()  / 2.0);
		head.setArcWidth(SnakeApp.getBlockSize() / 2.0);

		tail = head;

		for (int i = 1; i < initialSnakeLength; i++) {
			Block block = new Block(initialPositionX + i, initialPositionY, tail, field);
			blocks.add(block);
			tail = block;
		}
	}

	public int getDirection() {
		return head.direction;
	}

	public static int getIntitalSnakeLength() {
		return intitalSnakeLength;
	}

	public void setDirection(int direction) {
		head.direction = direction;
	}
}
