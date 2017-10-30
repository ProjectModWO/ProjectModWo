package game.entities.units;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import game.entities.Unit;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;

public class Collector extends Unit {

    public Collector(TransformComponent transform, PhysicsComponent physics) {
        super(transform, physics);
    }
}
