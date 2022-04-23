package league_invaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
boolean up;
boolean down;
boolean right;
boolean left;

	public Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}public void right(boolean right) {
		this.right = right;
	}public void left(boolean left) {
		this.left = left;
	}public void up(boolean up) {
		this.up = up;
	}public void down(boolean down) {
		this.down = down;
	}void update(){
		super.update();
		if(right) {
			x+=speed;
			
		}if(left) {
			x-=speed;
		}if(up) {
			y-=speed;
		}if(down) {
			y+=speed;
		}
	}
}
