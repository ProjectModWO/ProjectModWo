package window.rendering;

import lombok.Getter;
import math.Matrix4f;
import math.Transform2f1f;

public class AnimationObjectTemplate extends GraphicObjectTemplate{
	@Getter
	private long frameCount;
	@Getter
	private long duration;
	
	public AnimationObjectTemplate(float width, float height, Transform2f1f transform, String texturePath,
			Matrix4f pr_matrix, long id, long frameCount, long duration, float renderOrder) {
		super(width, height, transform, texturePath, pr_matrix, id, renderOrder);
		this.frameCount = frameCount;
		this.duration = duration;
	}

}
