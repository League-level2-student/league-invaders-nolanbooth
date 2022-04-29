package league_invaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	public Projectile(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, 10);
		
	}void update(){
		y-=speed;
		
	}void draw (Graphics g){
		g.setColor(Color.red);
		
	}

}
