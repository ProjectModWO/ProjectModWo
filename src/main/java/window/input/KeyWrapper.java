package window.input;

import math.Vector2f;

public class KeyWrapper {

	private final Key key;

	private final Action action;
	
	private final Vector2f pos;

	public KeyWrapper(Key key, Action action, Vector2f pos) {
		this.key = key;
		this.action = action;
		this.pos = pos;
	}

	public enum Key {
		
		MOUSE_BUTTON_1,
		MOUSE_BUTTON_2,
		MOUSE_BUTTON_3,
		MOUSE_BUTTON_4,
		MOUSE_BUTTON_5,
		MOUSE_BUTTON_6,
		MOUSE_BUTTON_7,
		MOUSE_BUTTON_8,
		MOUSE_BUTTON_9,
		MOUSE_BUTTON_0,
		MOUSE_BUTTON_LEFT,
		MOUSE_BUTTON_RIGHT,		
		MOUSE_BUTTON_MIDDLE,
		
		UNKNOWN;
		
		public static Key fromInt(int key) {
			switch(key) {
			case 0: return MOUSE_BUTTON_LEFT;
			case 1: return MOUSE_BUTTON_RIGHT;
			case 2: return MOUSE_BUTTON_MIDDLE;
				
			}
			return UNKNOWN;
		}

	}

	public enum Action {
		DOWN,
		UP,
		UNKNOWN;
		
		public static Action fromInt(int action) {
			
			switch(action) {
				case 0: return UP;
				case 1: return DOWN;
			}
			
			return UNKNOWN;
		}
	}

}
