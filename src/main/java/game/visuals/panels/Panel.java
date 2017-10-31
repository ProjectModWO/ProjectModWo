package game.visuals.panels;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import game.core.client.Clientgame;
import game.entities.Entity;
import game.entities.capabilities.IRenderable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {

    public Panel() {
        super(null, true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Todo implement render

        //Render entities
        for (Entity entity: Clientgame.getInstance().getEntityRegistrySnapshot()) {

            if (entity instanceof IRenderable){
                IRenderable renderable = (IRenderable) entity;

                BufferedImage image = renderable.getImage();
                //Todo drawing image with g.drawImage with the right scaling
            }
        }
    }
}
