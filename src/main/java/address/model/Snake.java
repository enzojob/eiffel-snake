package address.model;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Snake {

	ArrayList<Block> blocks = new ArrayList<Block>();

	Block head;
	Block tail;

	public Snake(int il, Field f) {
		int ipx = f.getW() / 2;
		int ipy = f.getH() / 2;

		head = new Block(ipx, ipy, null, f);
		blocks.add(head);

		head.setFill(Color.BLUE.desaturate());
		head.setArcHeight(Main_UI.blockSize);
		head.setArcWidth(Main_UI.blockSize);

		tail = head;

		for (int i = 1; i < il; i++) {
			Block b = new Block(ipx + i, ipy, tail, f);
			blocks.add(b);
			tail = b;
			tail.setFill(Color.FIREBRICK);
//			tail.setArcWidth(Main_UI.blockSize/2);
//			tail.setArcHeight(Main_UI.blockSize/2);
		}
	}

	public int getDirection() {
		return head.direction;
	}

	public void setDirection(int d) {
		head.direction = d;
	}
}