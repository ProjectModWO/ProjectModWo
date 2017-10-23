package game.entities.capabilities;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import game.physics.Position;

public interface ICanMove extends IMovable {

    /**
     * Moves the object to the target
     * @param target the target
     */
    void move(Position target);


}
