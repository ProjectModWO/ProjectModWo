package window.rendering;

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

	private ConcurrentLinkedQueue<GraphicObjectTemplate> addObjects = new ConcurrentLinkedQueue<GraphicObjectTemplate>();

	private ConcurrentLinkedQueue<Long> remObjects = new ConcurrentLinkedQueue<Long>();

	public RenderHandler(Window window) {

		this.window = window;

		pr_matrix = Matrix4f.orthographic(-window.getWidth() / 240, window.getWidth() / 240, -window.getHeight() / 240,
				window.getHeight() / 240, -1.0f, 1.0f);
		// activate OpenGL
		GL.createCapabilities();

		// set clear color
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		
		// enable objects to be drawn according to depth value 
		glEnable (GL_DEPTH_TEST); 
			

	}

	public void addNew(float width, float height, Transform2f1f transform, String texturePath, long id, float renderOrder) {

		GraphicObjectTemplate t = new GraphicObjectTemplate(width, height, transform, texturePath, pr_matrix, id, renderOrder);

		// queue t
		addObjects.add(t);

	}

	public boolean remove(long id) {
		return remObjects.add(id);
	}

	public void invalidate() {
		while (!addObjects.isEmpty()) {
			gobjects.add(new GraphicObject(addObjects.poll()));
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
		for (GraphicObject g : gobjects) {
			g.render();
		}
	}

}
