package utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * 
 * Holds all File related utility functions
 * 
 */

public class BufferUtils {

	private BufferUtils() {
	}

	/**
	 * Creates an LWJGL compliant ByteBuffer from an array.
	 * 
	 * @param array
	 * @return
	 */

	public static ByteBuffer createLWJGLByteBuffer(byte[] array) {

		ByteBuffer result = ByteBuffer.allocateDirect(array.length).order(ByteOrder.nativeOrder());
		result.put(array).flip();
		return result;
	}
	
	/**
	 * Creates an LWJGL compliant FloatBuffer from an array.
	 * 
	 * @param array
	 * @return
	 */

	public static FloatBuffer createLWJGLFloatBuffer(float[] array) {

		FloatBuffer result = ByteBuffer.allocateDirect(array.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
		result.put(array).flip();
		return result;
	}
	
	/**
	 * Creates an LWJGL compliant IntBuffer from an array.
	 * 
	 * @param array
	 * @return
	 */

	public static IntBuffer createLWJGLIntBuffer(int[] array) {

		IntBuffer result = ByteBuffer.allocateDirect(array.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
		result.put(array).flip();
		return result;
	}

}
