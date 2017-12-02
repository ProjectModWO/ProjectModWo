package window;

import org.lwjgl.glfw.*;

import lombok.Getter;
import window.input.InputHandler;
import window.rendering.RenderHandler;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * 
 * 
 * <p>Basic Window class
 * 
 * <p>Includes: 
 * 
 * <p>{@code InputHandler}, {@code RenderHandler} 
 * 
 * @author PCPCPC
 *
 */
public class Window implements Runnable {

	private long handle;

	@Getter
	private int width, height;

	private String title;

	private Thread thread;

	@Getter
	private boolean active = false;

	private final long  MS_PER_FRAME;
	
	public RenderHandler renderHandler;

	public InputHandler inputHandler;

	private boolean isFullscreen;

	public Window(int width, int height, String title, boolean createFullscreen, long framesPerSecond) {

		this.width = width;
		this.height = height;
		this.title = title;
		isFullscreen = createFullscreen;

		thread = new Thread(this, title);
		thread.start();
		while (!active) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		MS_PER_FRAME = 60 / framesPerSecond;
	}

	@Override
	public void run() {

		// init glfw
		if (!glfwInit()) {
			System.err.println("Could not initialize GLFW!");
			return;
		}

		// set error callback
		GLFWErrorCallback.createPrint(System.err).set();

		// configue window hints
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

		// create window and retrieve handle
		handle = glfwCreateWindow(width, height, title, glfwGetPrimaryMonitor(), NULL);
		if (handle == NULL) {
			System.err.println("Failed to create glfw Window");
			return;
		}
		
		//change to windowed if not created fullscreen
		if (!isFullscreen)
			setFullscreen(isFullscreen);
		
		glfwMakeContextCurrent(handle);

		glfwShowWindow(handle);

		// create Render Handler
		renderHandler = new RenderHandler(this);

		// create InputHandler
		inputHandler = new InputHandler(this);
		
		active = true;

		while (active) {
			
			long iterationStart = System.currentTimeMillis();
			
			renderHandler.invalidate();
			renderHandler.render();
			
			glFinish();
			
			inputHandler.update();
			
			try {
				long timeLeft = iterationStart + MS_PER_FRAME - System.currentTimeMillis();
				if (timeLeft > 0) 	
				Thread.sleep(timeLeft);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			active = !glfwWindowShouldClose(handle);
		}

		glfwDestroyWindow(handle);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}

	public long getID() {

		return handle;
	}

	public String getTitle() {
		return title;
	}

	public void toggleFullscreen() {
		setFullscreen(!isFullscreen);
	}
	
	public void setFullscreen(boolean fullscreen) {
		isFullscreen = fullscreen;
		
		long monitor = glfwGetPrimaryMonitor();
		GLFWVidMode vidmode = glfwGetVideoMode(monitor);
		if (fullscreen) {
			glfwSetWindowMonitor(handle, monitor, 0, 0, vidmode.width(), vidmode.height(), vidmode.refreshRate());
		} else {
			glfwSetWindowMonitor(handle, NULL, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2, width,
					height, vidmode.refreshRate());
		}

	}

	public void close() {
		glfwSetWindowShouldClose(handle, true);
	}

	public void onKey() {

	}

}
