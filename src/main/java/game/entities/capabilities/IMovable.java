package game.entities.capabilities;

import game.math.Vector;

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
     * Commands the movable to move with a specified impulse
     * @param impulse the impulse the object is given
     */
    void move(Vector impulse);

    /**
     * Commands the object to move with a given force
     * @param force the force that is used on the modpack
     * @param timeInMillis the time the force is occuring
     */
    void move(Vector force, double timeInMillis);
    


}
