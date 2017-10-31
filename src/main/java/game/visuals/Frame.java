package game.visuals;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Frame implements Runnable {

	private long window;

	private int width, height;
	
	private String title;
	
	private Thread thread;
	
	private boolean active = false;
	
	/*
	 * 
	 * Creates Window with width, height
	 * 
	 */
	public Frame(int width, int height, String title) {

		this.width = width;
		this.height = height;
		this.title = title;
		
		thread = new Thread(this, title);
		thread.start();
	}

	@Override
	public void run() {
		
		// init glfw (used for windows)		
		if (!glfwInit()) {
			
			System.err.println("Could not initialize GLFW!");
			return;
		}
		
		//create window and get reference
		window = glfwCreateWindow(width, height, title, glfwGetPrimaryMonitor(), NULL);
		
		if (window == NULL) {
			
			System.err.println("Failed to create glfw Window");
			return;
		}
		
		glfwWindowHint(GLFW_VISIBLE, GL_TRUE);
		
		
		while(active) {
			
		}
		
	}
	
	/*
	 * 
	 * Renders the Window to Screen
	 * 
	 */
	public void render() {

	}
	
}
