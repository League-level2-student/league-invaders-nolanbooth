package league_invaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
boolean up;
boolean down;
boolean right;
boolean left;
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;

	public Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		if (needImage) {
		    loadImage ("rocket.png");
		}
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
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
	}void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10, 10);
} 

}
