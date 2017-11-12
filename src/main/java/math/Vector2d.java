package math;

/*
 * 
 * 	Representation of Vectors and Points
 *
 */

import java.io.Serializable;

public class Vector2d implements Serializable{

	private double x1;
    private double x2;

    public enum Axis {

        X_AXIS(new Vector2d(1, 0)),
        Y_AXIS(new Vector2d(0, 1));

        private Vector2d v;

        Axis(Vector2d v) {
            this.v = v;
        }

        public Vector2d getV() {
            return v;
        }
    }

    public Vector2d(double[] args) {
        x1 = args[0];
        x2 = args[1];
    }

    public Vector2d(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "[ " + x1 + " | " + x2 +  " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector2d)) {
            return false;
        }

        Vector2d another = (Vector2d) obj;

        return x1 == another.x1 && x2 == another.x2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getAngle(Vector2d another) {

        return Math.acos(skalar(another) / (abs() * another.abs()));
    }

    public Vector2d multiply(double d) {
        return new Vector2d(x1 * d, x2 * d);
    }

    public Vector2d divide(double d) {
        return new Vector2d(x1 / d, x2 / d);
    }

    public double abs() {
        return Math.sqrt(x1 * x1 + x2 * x2);
    }

    public Vector2d add(Vector2d another) {
        return new Vector2d(x1 + another.x1,
                x2 + another.x2);
    }

    public Vector2d subtract(Vector2d another) {
        return new Vector2d(x1 - another.x1,
                x2 - another.x2);
    }

    public double skalar(Vector2d another) {

        return x1 * another.x1 + x2 * another.x2;
    }

    public Vector2d unify() {
        return divide(abs());
    }

    public void print() {
        System.out.println(this);
    }
    
    
    /**
     * Inverts the vector's direction, also called by -vector
     */
    public Vector2d negate() {
    	return new Vector2d(-x1, -x2);
    }
}
