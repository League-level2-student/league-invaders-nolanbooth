package league_invaders;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int currentState = MENU;
	Font titleFont;
	Font regFont;
	Timer frameDraw;
	Timer alienSpawn;
	Rocketship rocket = new Rocketship(250, 700, 50, 50, 3);
	ObjectManager objMan = new ObjectManager(rocket);

	public GamePanel() {
		if (needImage) {
			loadImage("space.png");
		}
		titleFont = new Font("Arial", Font.ITALIC, 48);
		regFont = new Font("Arial", Font.PLAIN, 20);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		startGame();
	}

	/**
	 * This method draws the menu state and sets the text
	 * 
	 * @param g
	 */
	void drawMenuState(Graphics g) {
		g.setColor(new Color(81, 130, 81));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", LeagueInvaders.WIDTH / 3 - 100, 150);
		g.setFont(regFont);
		g.drawString("Press ENTER to start", LeagueInvaders.WIDTH / 3, 400);
		g.drawString("SPACE for Directions", LeagueInvaders.WIDTH / 3, 500);

	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		}
		objMan.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(new Color(61, 15, 15));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(new Color(65, 115, 114));
		g.drawString("Game Over", LeagueInvaders.WIDTH / 3 - 65, 150);
		g.setFont(regFont);
		g.drawString("Press ENTER to play again", LeagueInvaders.WIDTH / 3 - 65, 400);
		g.drawString("SCORE = ", LeagueInvaders.WIDTH / 3, 300);
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objMan.update();
	}

	void updateEndState() {

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);

		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {

			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		// System.out.println("action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				alienSpawn.stop();
				currentState = MENU;
			} else if (currentState == GAME) {
				startGame();
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			objMan.rocket.up(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			objMan.rocket.down(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			objMan.rocket.right(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			objMan.rocket.left(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("PEW PEW");
			if (currentState == GAME) {
				objMan.addProjectile(objMan.rocket.getProjectile());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			objMan.rocket.right(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			objMan.rocket.left(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			objMan.rocket.up(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			objMan.rocket.down(false);
		}
	}

	void setRocketPos() {
		objMan.rocket.x = 250;
		objMan.rocket.y = 700;
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	void startGame() {
		alienSpawn = new Timer(1000, objMan);
		alienSpawn.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
