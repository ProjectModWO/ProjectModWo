package window.input;

import window.Window;
import window.input.InputWrapper.Action;
import window.input.InputWrapper.Key;

import java.nio.DoubleBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.lwjgl.BufferUtils;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import lombok.Getter;
import math.Vector2f;

/**
 * 
 * Provides a concurrent queue with input from window
 * 
 * <p>Is created automatically by {@code Window} objects
 * 
 * <p>Access queue using {@code InputHandler.getInputs()}
 * 
 * @author PCPCPC
 *
 */
public class InputHandler {

	private Window window;
	@Getter
	private ConcurrentLinkedQueue<InputWrapper> inputs = new ConcurrentLinkedQueue<InputWrapper>();

	public Vector2f getMousePos() {

		DoubleBuffer x = BufferUtils.createDoubleBuffer(1);

		DoubleBuffer y = BufferUtils.createDoubleBuffer(1);

		glfwGetCursorPos(this.window.getID(), x, y);

		return new Vector2f((float) x.get(), (float) y.get());

	}

	public InputHandler(Window window) {

		this.window = window;
		glfwSetKeyCallback(window.getID(), new KeyCallback(window, inputs));
		glfwSetMouseButtonCallback(window.getID(), new MouseButtonCallback(window, inputs));

	}

	protected class KeyCallback extends GLFWKeyCallback {

		private Window window;

		private ConcurrentLinkedQueue<InputWrapper> inputs;

		public KeyCallback(Window window, ConcurrentLinkedQueue<InputWrapper> inputs) {
			this.window = window;
			this.inputs = inputs;
		}

		@Override
		public void invoke(long window, int key, int scancode, int action, int mods) {
			DoubleBuffer x = BufferUtils.createDoubleBuffer(1);

			DoubleBuffer y = BufferUtils.createDoubleBuffer(1);

			glfwGetCursorPos(this.window.getID(), x, y);

			inputs.add(new InputWrapper(Key.fromInt(key), Action.fromInt(action),
					new Vector2f((float) x.get(), (float) y.get()), System.currentTimeMillis()));

		}

	}

	protected class MouseButtonCallback extends GLFWMouseButtonCallback {

		private Window window;

		private ConcurrentLinkedQueue<InputWrapper> inputs;

		public MouseButtonCallback(Window window, ConcurrentLinkedQueue<InputWrapper> inputs) {
			this.window = window;
			this.inputs = inputs;
		}

		@Override
		public void invoke(long window, int button, int action, int mods) {
			DoubleBuffer x = BufferUtils.createDoubleBuffer(1);

			DoubleBuffer y = BufferUtils.createDoubleBuffer(1);

			glfwGetCursorPos(this.window.getID(), x, y);

			inputs.add(new InputWrapper(Key.fromInt(button), Action.fromInt(action),
					new Vector2f((float) x.get(), (float) y.get()), System.currentTimeMillis()));

		}

	}

	public void update() {

		glfwPollEvents();
		
	}

}
