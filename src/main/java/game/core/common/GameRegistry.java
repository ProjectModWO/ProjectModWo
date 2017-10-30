package game.core.common;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import game.entities.Entity;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GameRegistry {

    private volatile Queue<Entity> entityRegistry;

    public GameRegistry() {

        entityRegistry = new ConcurrentLinkedQueue<>();
    }

    public void registerEntity(Entity entity){
        entityRegistry.add(entity);
    }

    public void removeEntity(Entity entity){
        entityRegistry.remove(entity);
    }

    public Entity[] getEntityRegistrySnapshot() {
        return (Entity[]) entityRegistry.toArray();
    }
}
