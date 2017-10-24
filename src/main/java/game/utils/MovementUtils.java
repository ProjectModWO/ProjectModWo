package game.utils;

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
    public static Vector impulse(Vector speedFrom, double massFrom, double massTo) {

        return speedFrom.unify().multiply(speedFrom.abs() * massFrom / massTo);

    }
}
