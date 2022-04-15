package league_invaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}public void right() {
		x+=speed;
	}public void left() {
		x-=speed;
	}public void up() {
		y-=speed;
	}public void down() {
		y+=speed;
	}
}
