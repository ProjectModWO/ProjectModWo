package game.entities.capabilities;

import game.physics.Position;

public interface ICanMove extends IMovable {

    /**
     * Moves the object to the target
     * @param target the target
     */
    void move(Position target);


}
