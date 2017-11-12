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
 * A Window Class
 * 
 * Is created on its own thread
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

	public RenderHandler renderHandler;

	public InputHandler inputHandler;
	
	public Window(int width, int height, String title) {

		this.width = width;
		this.height = height;
		this.title = title;

		thread = new Thread(this, title);
		thread.start();
		while (!active) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

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

		// center window
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(handle, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

		glfwMakeContextCurrent(handle);

		// Enable v-sync
		glfwSwapInterval(1);

		glfwShowWindow(handle);

		// create Render Handler
		renderHandler = new RenderHandler(this);

		// create InputHandler and link as a callback
		inputHandler = new InputHandler(this);

		active = true;

		while (active) {

			// clear buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			renderHandler.invalidate();
			renderHandler.render();

			glfwSwapBuffers(handle);

			glfwPollEvents();

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
	
	public void close() {
		glfwSetWindowShouldClose(handle, true);
	}
	
	public void onKey() {

	}

}
