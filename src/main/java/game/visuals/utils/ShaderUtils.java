package game.visuals.utils;

import static org.lwjgl.opengl.GL20.*;

import static game.utils.FileUtils.loadFileAsString;

import static org.lwjgl.opengl.GL11.GL_FALSE;
public class ShaderUtils {
	
	/**
	 * 
	 * Holds all Shader related utility functions
	 * 
	 */
	
	public ShaderUtils() {
	}
	
	
	/**
	 * 
	 * Loads vertex and fragment source from file and creates shader.
	 * Returns opengl reference to the created shader.
	 * 
	 * @param 
	 * @return int
	 */
	public static int loadAndCreate(String vertPath, String fragPath) {
		
		String vert = loadFileAsString(vertPath);
		String frag = loadFileAsString(fragPath);
		
		return create(vert, frag);

	}
	
	/**
	 * Creates opengl Shader from vertex and fragment code.
	 * 
	 * Returns opengl reference to the created shader.
	 * 
	 * @param 
	 * @return int
	 */
	public static int create(String vert, String frag) {
		
		int program = glCreateProgram();
		int vertID = glCreateShader(GL_VERTEX_SHADER);
		int	fragID = glCreateShader(GL_FRAGMENT_SHADER);
		
		glShaderSource(vertID, vert);
		glShaderSource(fragID, frag);
		
		glCompileShader(vertID);
		if (glGetShaderi(vertID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to compile vertex shaders!");
			System.err.println(glGetShaderInfoLog(vertID, 2048));
		}
		
		glCompileShader(fragID);	
		if (glGetShaderi(fragID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to compile fragment shaders!");
			System.err.println(glGetShaderInfoLog(fragID, 2048));
		}
		
		glAttachShader(program, vertID);
		glAttachShader(program, fragID);
		
		glLinkProgram(program);
		glValidateProgram(program);
		
		return program;
		
	}

}
