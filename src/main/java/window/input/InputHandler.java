package window.input;

import window.Window;
import window.input.KeyWrapper.Action;
import window.input.KeyWrapper.Key;

import java.nio.DoubleBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.lwjgl.BufferUtils;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import lombok.Getter;
import math.Vector2f;

public class InputHandler {

	private Window window;
	@Getter
	private ConcurrentLinkedQueue<KeyWrapper> inputs = new ConcurrentLinkedQueue<KeyWrapper>();

	public InputHandler(Window window) {

		this.window = window;

		glfwSetKeyCallback(window.getID(), new KeyCallback(window, inputs));
		glfwSetMouseButtonCallback(window.getID(), new MouseButtonCallback(window, inputs));

	}

	protected class KeyCallback extends GLFWKeyCallback {

		private Window window;

		private ConcurrentLinkedQueue<KeyWrapper> inputs;

		public KeyCallback(Window window, ConcurrentLinkedQueue<KeyWrapper> inputs) {
			this.window = window;
			this.inputs = inputs;
		}

		@Override
		public void invoke(long window, int key, int scancode, int action, int mods) {
			DoubleBuffer x = BufferUtils.createDoubleBuffer(1);

			DoubleBuffer y = BufferUtils.createDoubleBuffer(1);

			glfwGetCursorPos(this.window.getID(), x, y);

			inputs.add(new KeyWrapper(Key.fromInt(key), Action.fromInt(action),
					new Vector2f((float) x.get(), (float) y.get())));

		}

	}

	protected class MouseButtonCallback extends GLFWMouseButtonCallback {

		private Window window;

		private ConcurrentLinkedQueue<KeyWrapper> inputs;
		
		public MouseButtonCallback(Window window, ConcurrentLinkedQueue<KeyWrapper> inputs) {
			this.window = window;
			this.inputs = inputs;
		}
		
		@Override
		public void invoke(long window, int button, int action, int mods) {
			DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
			
			DoubleBuffer y = BufferUtils.createDoubleBuffer(1);
			
			glfwGetCursorPos(this.window.getID(), x, y);
			
			inputs.add(new KeyWrapper(Key.fromInt(button), Action.fromInt(action), new Vector2f((float)x.get(), (float)y.get())));
		
		}
		
	}

}
