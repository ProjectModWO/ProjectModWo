package game.visuals;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Toolkit tk = getToolkit();
	
	public GameFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(0, 0, tk.getScreenSize().width, tk.getScreenSize().height);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
	}

}
