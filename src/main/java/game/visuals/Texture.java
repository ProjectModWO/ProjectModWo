package game.visuals;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import game.utils.BufferUtils;
import lombok.Getter;

import javax.imageio.ImageIO;

import static org.lwjgl.opengl.GL11.*;

/**
 * 
 * Holds ID, width, height of an OpenGL 2D Texture
 *
 */
public class Texture {
	
	private @Getter int  width, height;
	
	private int texture;

	public Texture() {
	}

	public Texture(String path) {
		texture = loadFromFile(path);
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
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, BufferUtils.createLWJGLIntBuffer(data));
		glBindTexture(GL_TEXTURE_2D, 0);
		
		return tex;
	}
	
	public int getID() {
		
		return texture;
	}

}
