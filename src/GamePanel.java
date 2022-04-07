import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	Font titleFont;
	Font regFont;
	Timer frameDraw;
	public GamePanel() {
		titleFont = new Font("Arial", Font.ITALIC, 48);
		regFont = new Font("Arial", Font.PLAIN, 20);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
	}
	/**
	 * This method draws the menu state and sets the text 
	 * @param g
	 */
	void drawMenuState(Graphics g) {
		g.setColor(new Color(81,130,81));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		    g.setColor(Color.YELLOW);
		    g.drawString("League Invaders", LeagueInvaders.WIDTH/3 - 100, 150);
		    g.setFont(regFont);
		    g.drawString("Press ENTER to start", LeagueInvaders.WIDTH/3, 400);
		    g.drawString("SPACE for Directions", LeagueInvaders.WIDTH/3, 500);
		    
	}void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			}void drawEndState(Graphics g){
		g.setColor(new Color(61,15, 15));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
		g.setColor(new Color(65,115,114));
		g.drawString("Game Over", LeagueInvaders.WIDTH/3-65, 150);
		g.setFont(regFont);
		g.drawString("insert score here", 0, 0);
	}void updateMenuState(){
		
	}void updateGameState(){
		
	}void updateEndState(){
		
	}
	
	int currentState = MENU;
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}
}
