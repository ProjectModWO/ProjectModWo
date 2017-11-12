package game.entities.capabilities;
/*
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import game.entities.components.PhysicsComponent;
import math.Vector2d;

public interface IMovable {

    /**
     * gets the phsyical component
     * @return Phsyical Component
     */
    PhysicsComponent getPhyComp();

    /**
     * Commands the movable to move with a specified impulse
     * @param impulse the impulse the object is given
     */
    void move(Vector2d impulse);

    /**
     * Commands the object to move with a given force
     * @param force the force that is uded on the modpack
     * @param timeInMillis the time the force is occuring
     */
    void move(Vector2d force, double timeInMillis);

    Vector2d getImpulse();

}
