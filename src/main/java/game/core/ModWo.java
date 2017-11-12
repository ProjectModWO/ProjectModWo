package game.core;

import math.Transform2f1f;
import window.Window;

public class ModWo {

	public ModWo() throws InterruptedException {
		// create a new window
		Window window = new Window(1920, 1080, "ModWo");
		
		Transform2f1f t = new Transform2f1f();
		
		//add some graphics
		window.renderHandler.addNew(16.0f, 9.0f, new Transform2f1f(), "res/bg.png", 0);
		window.renderHandler.addNew(1.5f, 1.5f, t, "res/player1.png", 1);
		
		//change the Transform
		while(window.isActive()) {
			Thread.sleep(10);
			t.setRotation((float) (t.getRotation() + Math.PI / 360 * 32));
			if (!window.inputHandler.getInputs().isEmpty()) {
				window.close();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ModWo();
	}
}