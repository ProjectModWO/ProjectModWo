package game.core.client;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import game.core.common.GameRegistry;
import game.entities.Entity;
import lombok.Getter;

/**
 * Used for all clientside features
 */
public class Clientgame {

    public static final int FPS = 20;
    public static final int FPS_DELAY = 1000 / FPS;

    @Getter
    private static Clientgame instance;

    //Registry related
    private GameRegistry registry;

    public Clientgame() {

    
    }

    public Entity[] getEntityRegistrySnapshot() {
        return registry.getEntityRegistrySnapshot();
    }
}
