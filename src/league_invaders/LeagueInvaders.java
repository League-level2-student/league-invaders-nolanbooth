package league_invaders;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gamepanel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	public static void main(String[] args) {
		LeagueInvaders invader = new LeagueInvaders();
		invader.setup();
	}

	public LeagueInvaders() {
		frame = new JFrame();
		gamepanel = new GamePanel();
	}

	void setup() {
		frame.add(gamepanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamepanel);
	}
}
