package league_invaders;
import java.util.ArrayList;
import java.util.Random;
public class ObjectManager {
Rocketship rocket;
ArrayList projectiles = new ArrayList();
ArrayList aliens = new ArrayList();
Random random = new Random();

ObjectManager(Rocketship rocket){
		this.rocket = rocket;
	}void addProjectile(Projectile p){
		
		
	}void addAlien(){
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}

}
