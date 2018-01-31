package window.rendering;

import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.opengl.GL11.*;
import java.util.ArrayList;

import org.lwjgl.opengl.GL;

import java.util.concurrent.ConcurrentLinkedQueue;
import math.Matrix4f;
import math.Transform2f1f;
import window.Window;

public class RenderHandler {

	private Window window;

	private Matrix4f pr_matrix;

	private ArrayList<GraphicObject> gobjects = new ArrayList<GraphicObject>();

	private ConcurrentLinkedQueue<GraphicObjectTemplate> addGraphicObjects = new ConcurrentLinkedQueue<GraphicObjectTemplate>();

	private ConcurrentLinkedQueue<AnimationObjectTemplate> addAnimationObjects = new ConcurrentLinkedQueue<AnimationObjectTemplate>();

	private ConcurrentLinkedQueue<Long> remObjects = new ConcurrentLinkedQueue<Long>();

	public RenderHandler(Window window) {

		this.window = window;

		pr_matrix = Matrix4f.orthographic(-window.getWidth() / 2, window.getWidth() / 2, -window.getHeight() / 2,
				window.getHeight() / 2, -1.0f, 1.0f);

		// activate OpenGL
		GL.createCapabilities();

		// set clear color
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

		// enable objects to be drawn according to depth value
		glEnable(GL_DEPTH_TEST);

		// set LinearBlend
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glEnable(GL_BLEND);

	}

	public void addGraphicObject(float width, float height, Transform2f1f transform, String texturePath, long id,
			float renderOrder) {

		GraphicObjectTemplate t = new GraphicObjectTemplate(width, height, transform, texturePath, pr_matrix, id,
				renderOrder);

		// queue t
		addGraphicObjects.add(t);

	}
	
	public void addAnimationObject(float width, float height, Transform2f1f transform, String texturePath, long id, long frameCount, long duration,
			float renderOrder) {

		AnimationObjectTemplate t = new AnimationObjectTemplate(width, height, transform, texturePath, pr_matrix, id, frameCount, duration,
				renderOrder);

		// queue t
		addAnimationObjects.add(t);

	}
	public boolean remove(long id) {
		return remObjects.add(id);
	}

	public void invalidate() {
		while (!addGraphicObjects.isEmpty()) {
			gobjects.add(new GraphicObject(addGraphicObjects.poll()));
		}
		while (!addAnimationObjects.isEmpty()) {
			gobjects.add(new AnimationObject(addAnimationObjects.poll()));
		}
		while (!remObjects.isEmpty()) {
			long id = remObjects.poll();
			for (GraphicObject g : gobjects) {
				if (g.getId() == id) {
					gobjects.remove(g);
				}
			}

		}
		for (GraphicObject g : gobjects) {
			g.invalidate();
		}
	}

	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		for (GraphicObject g : gobjects) {
			g.render();
		}
		glfwSwapBuffers(window.getID());
	}

}
