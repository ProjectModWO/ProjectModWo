package window.rendering;

import lombok.Getter;
import lombok.Setter;
import math.Matrix4f;
import math.Transform2f1f;

@Getter
@Setter
public class GraphicObjectTemplate {
	
	private float width, height;
	private Transform2f1f transform;
	private String texturePath;
	private Matrix4f pr_matrix;
	private long id;
	private float renderOrder;
	
	public GraphicObjectTemplate(float width, float height, Transform2f1f transform, String texturePath, Matrix4f pr_matrix, long id, float renderOrder) {
		this.width = width;
		this.height = height;
		this.transform = transform;
		this.texturePath = texturePath;
		this.pr_matrix = pr_matrix;
		this.id = id;
		this.renderOrder = renderOrder;			
	}
	
	
	
}