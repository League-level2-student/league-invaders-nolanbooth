package league_invaders;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive = true;

	public GameObject(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}

	void update() {

	}

}
