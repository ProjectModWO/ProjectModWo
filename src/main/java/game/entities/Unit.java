package game.entities;
/*
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import game.entities.capabilities.ICanMove;
import game.entities.capabilities.IRenderable;
import game.entities.capabilities.ITickable;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import math.Vector2d;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Unit extends Entity implements IRenderable, ITickable, ICanMove{

    private BufferedImage img;



    public Unit(TransformComponent transform, PhysicsComponent physics) {
        super(transform, physics);

        try {
            img = ImageIO.read(new File("placeholder"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public BufferedImage getImage() {
        return img;
    }

    @Override
    public void tick() {

    }

    @Override
    public void move(TransformComponent target) {

    }

    @Override
    public PhysicsComponent getPhyComp() {
        return null;
    }

    @Override
    public void move(Vector2d impulse) {

    }

    @Override
    public void move(Vector2d force, double timeInMillis) {

    }

    @Override
    public Vector2d getImpulse() {
        return null;
    }

	@Override
	public void execute(byte ident, Serializable... args) {
		// TODO Auto-generated method stub
		
	}
}
