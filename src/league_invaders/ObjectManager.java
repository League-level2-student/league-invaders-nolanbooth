package league_invaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score;

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);

	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	void update() {
		rocket.update();
		for (Alien a : aliens) {
			a.update();
			if (a.y >= LeagueInvaders.HEIGHT) {
				a.isActive = false;

			}
		}
		for (Projectile pro : projectiles) {
			pro.update();
			if (pro.y <= 0) {
				pro.isActive = false;
			}
		}

		checkCollision();
		purgeObjects();

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (Alien a : aliens) {
			a.draw(g);
		}
		for (Projectile pro : projectiles) {
			pro.draw(g);
		}
	}

	void purgeObjects() {
		for (int i = aliens.size() - 1; i >= 0; i--) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = projectiles.size() - 1; i >= 0; i--) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}
	public int getScore() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();

	}

	public void checkCollision() {
		for (Alien a : aliens) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				a.isActive = false;
				rocket.isActive = false;
				// SINGLE SET COUPLE COMPARE
			}
			for (Projectile pro : projectiles) {
				if (pro.collisionBox.intersects(a.collisionBox)) {
					a.isActive = false;
					score += 1;
				}
			}
		}
	}

}
