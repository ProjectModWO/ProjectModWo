package window.rendering;

public class AnimationObject extends GraphicObject {

	private Texture[] textures;

	private long duration;

	private long startTime;

	private long counter = 0;

	public AnimationObject(AnimationObjectTemplate template) {
		super(template);
		this.duration = template.getDuration();
		textures = new Texture[(int) (template.getFrameCount())];
		textures[0] = texture;
		if (template.getFrameCount() > 1) {
			String s = template.getTexturePath();
			String[] FilePathParts = s.split("\\.");
			for (int i = 1; template.getFrameCount() > i; i++) {
				textures[i] = new Texture(FilePathParts[0] + i + "." + FilePathParts[1]);

			}
		}
		startTime = System.nanoTime();
	}

	public void render() {
		double elapsed = System.nanoTime() - startTime;
		while (elapsed > (1 + counter) * duration) {
			elapsed = -duration;
			counter++;
		}
		System.out.println(counter);
		shader.enable();
		textures[(int) (counter % textures.length)].bind();
		vertexArray.render();
		textures[(int) (counter % textures.length)].unbind();
		shader.disable();
	}

}
