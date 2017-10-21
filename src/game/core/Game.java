package game.core;

import javax.swing.JFrame;

public class Game extends JFrame {
	
	public Game() {
		
		setBounds(500, 200, 500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Game();	
		
	}
}
