package game.utils;

import math.Vector2d;

public class MovementUtils {

    /**
     * Method to simulate an inelastic hit with 100% energy given to the target object
     * Target object is not moving
     *
     * @param speedFrom the speed of the hitter
     * @param massFrom  the mass of the hitter
     * @param massTo    the mass of the hit object
     * @return the vector of the new speed
     */
    public static Vector2d impulse(Vector2d speedFrom, double massFrom, double massTo) {

        return speedFrom.unify().multiply(speedFrom.abs() * massFrom / massTo);

    }
}
