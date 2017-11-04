package game.visuals;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Frame implements Runnable {

	private long window;

	private int width, height;

	private String title;

	private Thread thread;

	private boolean active = false;

	public Frame(int width, int height, String title) {

		this.width = width;
		this.height = height;
		this.title = title;

		thread = new Thread(this, title);
		thread.start();
	}

	@Override
	public void run() {

		init();

		while (active) {
			render();
			active = !glfwWindowShouldClose(window);
		}

		deInit();

	}

	private void init() {

		// basic Error callback, will print in System.err
		GLFWErrorCallback.createPrint(System.err).set();

		// init glfw (used for windows)
		if (!glfwInit()) {

			System.err.println("Could not initialize GLFW!");
			return;
		}

		// Configure GLFW
		glfwDefaultWindowHints(); // set default windowhints
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

		// create window and get reference
		window = glfwCreateWindow(width, height, title, NULL, NULL);

		if (window == NULL) {

			System.err.println("Failed to create glfw Window");
			return;
		}

		// Get the thread stack and push a new frame
		try (MemoryStack stack = stackPush()) {
			IntBuffer pWidth = stack.mallocInt(1); // int*
			IntBuffer pHeight = stack.mallocInt(1); // int*

			// Get the window size passed to glfwCreateWindow
			glfwGetWindowSize(window, pWidth, pHeight);

			// Get the resolution of the primary monitor
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			// Center the window
			glfwSetWindowPos(window, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
		} // the stack frame is popped automatically

		// Make the OpenGL context current
		glfwMakeContextCurrent(window);
		// Enable v-sync
		glfwSwapInterval(1);

		// Make the window visible
		glfwShowWindow(window);

		GL.createCapabilities();
		
		// Set the clear color
		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
		
		active = true;

	}

	private void deInit() {
		glfwDestroyWindow(window);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}

	private void render() {
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glfwSwapBuffers(window);
		
		glfwPollEvents();
	}

}
