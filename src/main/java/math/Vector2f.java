package math;

/*
 * 
 * 	Representation of Vectors and Points
 *
 */

import java.io.Serializable;

import lombok.Setter;

@Setter
public class Vector2f implements Serializable{

	private float x1;
    private float x2;

    public enum Axis {

        X_AXIS(new Vector2f(1, 0)),
        Y_AXIS(new Vector2f(0, 1));

        private Vector2f v;

        Axis(Vector2f v) {
            this.v = v;
        }

        public Vector2f getV() {
            return v;
        }
    }

    public Vector2f(float[] args) {
        x1 = args[0];
        x2 = args[1];
    }

    public Vector2f(float x1, float x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "[ " + x1 + " | " + x2 +  " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector2f)) {
            return false;
        }

        Vector2f another = (Vector2f) obj;

        return x1 == another.x1 && x2 == another.x2;
    }

    public float getX1() {
        return x1;
    }

    public float getX2() {
        return x2;
    }

    public float getAngle(Vector2f another) {

        return (float) Math.acos(skalar(another) / (abs() * another.abs()));
    }

    public Vector2f multiply(float d) {
        return new Vector2f(x1 * d, x2 * d);
    }

    public Vector2f divide(float d) {
        return new Vector2f(x1 / d, x2 / d);
    }

    public float abs() {
        return (float) Math.sqrt(x1 * x1 + x2 * x2);
    }

    public Vector2f add(Vector2f another) {
        return new Vector2f(x1 + another.x1,
                x2 + another.x2);
    }

    public Vector2f subtract(Vector2f another) {
        return new Vector2f(x1 - another.x1,
                x2 - another.x2);
    }

    public float skalar(Vector2f another) {

        return x1 * another.x1 + x2 * another.x2;
    }

    public Vector2f unify() {
        return divide(abs());
    }

    public void print() {
        System.out.println(this);
    }
    
    
    /**
     * Inverts the vector's direction, also called by -vector
     */
    public Vector2f negate() {
    	return new Vector2f(-x1, -x2);
    }
}
