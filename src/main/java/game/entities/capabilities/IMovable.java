package game.entities.capabilities;

import game.utils.Position;
import game.utils.Vector;

public interface IMovable {

    /**
     * Gets the weight of the Movable Object
     *
     * @return weight
     */
    double getWeight();

    /**
     * Gets the speed vector of the movable object
     *
     * @return Speed vector, vector length indicates the speed
     */
    Vector getSpeed();

    /**
     * Gets the acceleration of the movable object
     *
     * @return acceleration vector, length indicates value
     */
    Vector getAcceleration();

    /**
     * Commands the movable to move to a specified location
     *
     * @param position the target position
     */
    void move(Position position);

}
