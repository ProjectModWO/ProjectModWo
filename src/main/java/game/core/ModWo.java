package game.core;

import math.Transform2f1f;
import math.Vector2f;
import window.Window;
import window.input.InputWrapper;

public class ModWo {

	public ModWo() throws InterruptedException {
		// create a new window
		Window window = new Window(1920, 1080, "ModWo", true, 60);

		Transform2f1f t = new Transform2f1f();

		// add some graphics
		window.renderHandler.addNew(1920.0f, 1080.0f, new Transform2f1f(new Vector2f(0,0), 0), "res/bg.png", 0, -0.5f);
		window.renderHandler.addNew(256, 256f, t, "res/alpha_test.png", 1, 0.0f);

		while (window.isActive()) {
			Thread.sleep(1);
			//Vector2f v = new Vector2f(0,0);
			Vector2f v = window.inputHandler.getMousePos();
			t.setPosition(new Vector2f((v.getX1() - window.getWidth() / 2) / 1,
					(v.getX2() - window.getHeight() / 2) / -1));
			if (window.inputHandler.getInputs().peek() != null)
			{
				InputWrapper k = window.inputHandler.getInputs().poll();
				if (k.getKey() == InputWrapper.Key.MOUSE_BUTTON_LEFT && k.getAction() == InputWrapper.Action.UP)
					window.toggleFullscreen();
				if (k.getKey() == InputWrapper.Key.KEYBOARD_BUTTON_ESCAPE && k.getAction() == InputWrapper.Action.UP)
					window.close();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ModWo();
	}
}