package graphics;

import graphics.utils.ShaderUtils;
import math.Vector3f;

import static org.lwjgl.opengl.GL20.*;

public class Shader {

	private int ID;
	
	public Shader(int ID) {
		
		this.ID = ID;
	}
	
	public Shader(String vertPath, String fragPath) {
		this.ID = ShaderUtils.loadAndCreate(vertPath, fragPath);
	}
	
	public int getUniform(String name) {
		return  glGetUniformLocation(ID, name);
	}
	
	public void setUniform3f(String name, Vector3f vector) {
		glUniform3f(getUniform(name), (float) vector.getX1(), (float) vector.getX2(), (float) vector.getX3());
	}
	
	public void enable() {
		glUseProgram(ID);
	}
	
	public void disable() {
		glUseProgram(0);
	}

}
