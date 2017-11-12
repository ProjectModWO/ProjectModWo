package window.rendering;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import window.utils.BufferUtils;

public class VertexArray {

	private int count;

	// vao = vertex array object
	// vbo = vertex Buffer object
	// ibo = index buffer object
	// tco = texture coordinate buffer object
	private int vao, vbo, ibo, tbo;

	public VertexArray(float width, float height) {
		this(new float[] { 
				-width / 2, height / 2, 0.0f,
				width / 2, height / 2, 0.0f,
				width / 2, -height / 2, 0.0f,
				-width / 2, -height / 2, 0.0f
				}, 
				new byte[] 
						{ 0, 1,
								2, 2,
								3, 0 },
				new float[] { 0, 1,
						0, 0,
						1, 0,
						1, 1 });

	}

	public VertexArray(float[] vertices, byte[] indices, float[] textureCoordinates) {

		count = indices.length;

		// create new VertexArray and bind it
		vao = glGenVertexArrays();
		glBindVertexArray(vao);

		// add the Vertices to Array
		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, BufferUtils.createLWJGLFloatBuffer(vertices), GL_STATIC_DRAW);
		glVertexAttribPointer(Shader.VERTEX_ATTRIB, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(Shader.VERTEX_ATTRIB);

		// add the texture coordinates to array
		tbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, tbo);
		glBufferData(GL_ARRAY_BUFFER, BufferUtils.createLWJGLFloatBuffer(textureCoordinates), GL_STATIC_DRAW);
		glVertexAttribPointer(Shader.TCOORD_ATTRIB, 2, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(Shader.TCOORD_ATTRIB);

		// create a buffer for our indices
		ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, BufferUtils.createLWJGLByteBuffer(indices), GL_STATIC_DRAW);

		// unbind everything
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}

	public void bind() {
		glBindVertexArray(vao);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
	}

	public void unbind() {
		glBindVertexArray(0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}

	public void draw() {
		glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_BYTE, 0);
	}

	public void render() {
		bind();
		draw();
		unbind();
	}

}
