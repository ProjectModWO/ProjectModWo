package game.visuals;

import game.visuals.panels.GamePanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Toolkit tk = getToolkit();

	//panels
	@Getter
	private GamePanel gamePanel;


	public GameFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(0, 0, tk.getScreenSize().width, tk.getScreenSize().height);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
	}

}
