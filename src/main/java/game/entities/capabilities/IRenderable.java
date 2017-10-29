package game.entities.capabilities;

import java.awt.image.BufferedImage;

import game.math.Position;

public interface IRenderable {
	
	public BufferedImage getImage();
	
	public Position getPosition();
}
