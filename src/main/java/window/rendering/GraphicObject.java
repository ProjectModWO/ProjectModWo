package window.rendering;

import lombok.Getter;
import lombok.Setter;
import math.Matrix4f;
import math.Transform2f1f;
import math.Vector3f;

@Getter
@Setter
public class GraphicObject {
	
	private VertexArray vertexArray;

	private Shader shader;

	private Texture texture;

	private Transform2f1f transform;

	private Matrix4f pr_matrix;
	
	private float renderOrder;
	
	private final long id;
	
	public GraphicObject(GraphicObjectTemplate template) {
		this(new VertexArray(template.getWidth(), template.getHeight()),
				new Shader("shaders/shader.vert", "shaders/shader.frag"), new Texture(template.getTexturePath()),
				template.getTransform(), template.getPr_matrix(), template.getId(), template.getRenderOrder());
	}

	public GraphicObject(VertexArray vertexArray, Shader shader, Texture texture, Transform2f1f transform,
			Matrix4f pr_matrix, long id, float renderOrder) {

		this.vertexArray = vertexArray;
		this.shader = shader;
		this.texture = texture;
		this.transform = transform;
		this.pr_matrix = pr_matrix;
		this.id = id;
		this.renderOrder = renderOrder;
	}

	public void render() {
		shader.enable();
		texture.bind();
		vertexArray.render();
		texture.unbind();
		shader.disable();
	}

	public void invalidate() {
		shader.setUniformMat4f("pr_matrix", pr_matrix);
		shader.setUniformMat4f("tr_matrix", Matrix4f.translate(new Vector3f(transform.getPosition(), renderOrder)));
		shader.setUniformMat4f("rt_matrix", Matrix4f.rotate(transform.getRotation()));
	}	
	

}
