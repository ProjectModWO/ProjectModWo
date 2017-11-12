package window.input;

import org.lwjgl.glfw.*;

import window.Window;

import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class InputHandler extends GLFWKeyCallback {
	
	private Window window;
	
	private ArrayList<KeyListener> subscriptions = new ArrayList<KeyListener>();
	
	private ConcurrentLinkedQueue<Long> addSubs = new ConcurrentLinkedQueue<Long>();
	
	private ConcurrentLinkedQueue<Long> remSubs = new ConcurrentLinkedQueue<Long>();
	
	public InputHandler(Window window) {
		
		this.window = window;
	
	}

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		 
	}
	
	
	
}
