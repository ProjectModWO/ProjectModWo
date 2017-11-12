package window.input;

import static org.lwjgl.glfw.GLFW.*;

public abstract class KeyListener {

	private boolean pressed = false;

	private long key = GLFW_KEY_UNKNOWN;

	public void invoke(long action) {
		if (action == GLFW_PRESS) {
			pressed = true;
			onDown();
		} else if (action == GLFW_RELEASE) {
			pressed = false;	
			onUp();
		}
	}

	public KeyListener(long key) {
		this.key = key;
	}
	
	public long getKey() {
		return key;
	}
	
	public boolean isPressed() {
		return pressed;
	}

	public abstract void onUp();

	public abstract void onDown();
}
