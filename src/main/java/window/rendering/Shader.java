package window.rendering;

import math.Matrix4f;
import math.Vector2f;
import math.Vector3f;
import window.rendering.utils.ShaderUtils;
import window.utils.BufferUtils;

import static org.lwjgl.opengl.GL20.*;

import java.util.HashMap;
import java.util.Map;

public class Shader {

	public static final int VERTEX_ATTRIB = 0;
	public static final int TCOORD_ATTRIB = 1;
	
	public static int shaderUsed = 0;
	
	private int ID;
	
	private Map<String, Integer> locationCache = new HashMap<String, Integer>();
	
	public Shader(int ID) {
		
		this.ID = ID;
	}
	
	public Shader(String vertPath, String fragPath) {
		this.ID = ShaderUtils.loadAndCreate(vertPath, fragPath);
	}
	
	public int getUniform(String name) {
		if (locationCache.containsKey(name)) 
			return locationCache.get(name);
		int result = glGetUniformLocation(ID, name);
		if (result == - 1) 
			System.err.println("Could not find uniform variable '" + name + "'!");
		else 
			locationCache.put(name, result);
		return result;
	}
	
	public void setUniform1i(String name, int value) {
		enable();
		glUniform1i(getUniform(name), value);
	}
	
	public void setUniform1f(String name, float value) {
		enable();
		glUniform1f(getUniform(name), value);
	}
	
	public void setUniform2f(String name, Vector2f vector) {
		enable();
		glUniform2f(getUniform(name), vector.getX1(),  vector.getX2());
	}
	
	public void setUniform3f(String name, Vector3f vector) {
		enable();
		glUniform3f(getUniform(name), vector.getX1(), vector.getX2(),  vector.getX3());
	}
	
	public void setUniformMat4f(String name, Matrix4f matrix) {
		enable();
		glUniformMatrix4fv(getUniform(name), false, BufferUtils.createLWJGLFloatBuffer(matrix.elements));
	}
	
	public void enable() {
		useShader(ID);
	}
	
	public void disable() {
		useShader(0);
	}
	
	public static void useShader(int shader) {
		if (shaderUsed != shader) {
			glUseProgram(shader);
			shaderUsed = shader;
		}
	}
	
	@Override
	protected void finalize() {
		disable();
	}

}
