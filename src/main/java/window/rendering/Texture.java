package window.rendering;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import lombok.Getter;
import window.utils.BufferUtils;

import javax.imageio.ImageIO;

import static org.lwjgl.opengl.GL11.*;

/**
 * 
 * OpenGL 2D Texture
 *
 */
public class Texture {

	private static HashMap<String, Texture> textures = new HashMap<String, Texture>();

	private @Getter int width, height;

	private int handle;

	public Texture() {
	}

	public Texture(String path) {
		handle = loadFromFile(path);
	}

	public static Texture get(String path) {

		if (textures.containsKey(path)) {
			return textures.get(path);
		} else {
			Texture texture = new Texture(path);
			textures.put(path, texture);
			return texture;
		}

	}

	public int loadFromFile(String path) {

		int[] pixels = null;
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int[] data = new int[width * height];
		for (int i = 0; i < width * height; i++) {
			int a = (pixels[i] & 0xff000000) >> 24;
			int r = (pixels[i] & 0xff0000) >> 16;
			int g = (pixels[i] & 0xff00) >> 8;
			int b = (pixels[i] & 0xff);

			data[i] = a << 24 | b << 16 | g << 8 | r;
		}

		int tex = glGenTextures();

		glBindTexture(GL_TEXTURE_2D, tex);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE,
				BufferUtils.createLWJGLIntBuffer(data));
		glBindTexture(GL_TEXTURE_2D, 0);

		return tex;
	}

	public int getID() {

		return handle;
	}

	public void bind() {

		glBindTexture(GL_TEXTURE_2D, handle);
	}

	public void unbind() {

		glBindTexture(GL_TEXTURE_2D, 0);
	}

}
