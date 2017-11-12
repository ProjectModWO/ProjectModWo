package math;

import java.io.Serializable;

public class Vector3f implements Serializable{

    private float x1;
    private float x2;
    private float x3;

    public enum RoomAxis {

        X_AXIS(new Vector3f(1, 0, 0)),
        Y_AXIS(new Vector3f(0, 1, 0)),
        Z_AXIS(new Vector3f(0, 0, 1));

        private Vector3f v;

        RoomAxis(Vector3f v) {
            this.v = v;
        }

        public Vector3f getV() {
            return v;
        }
    }
   
    public Vector3f(Vector2f vec, float x3) {
    	this(vec.getX1(), vec.getX2(), x3);
    }
    
    public Vector3f(float[] args) {
        x1 = args[0];
        x2 = args[1];
        x3 = args[2];
    }

    public Vector3f(float x1, float x2, float x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    @Override
    public String toString() {
        return "[ " + x1 + " | " + x2 + " | " + x3 + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector3f)) {
            return false;
        }

        Vector3f another = (Vector3f) obj;

        return x1 == another.x1 && x2 == another.x2 && x3 == another.x3;
    }

    public float getX1() {
        return x1;
    }

    public float getX2() {
        return x2;
    }

    public float getX3() {
        return x3;
    }

    public float getAngle(Vector3f another) {

        return (float) Math.acos(skalar(another) / (abs() * another.abs()));
    }

    public Vector3f multiply(float d) {
        return new Vector3f(x1 * d, x2 * d, x3 * d);
    }

    public Vector3f divide(float d) {
        return new Vector3f(x1 / d, x2 / d, x3 / d);
    }

    public float abs() {
        return (float) Math.sqrt(x1 * x1 + x2 * x2 + x3 * x3);
    }

    public Vector3f add(Vector3f another) {
        return new Vector3f(x1 + another.x1,
                x2 + another.x2,
                x3 + another.x3);
    }

    public Vector3f subtract(Vector3f another) {
        return new Vector3f(x1 - another.x1,
                x2 - another.x2,
                x3 - another.x3);
    }

    public float skalar(Vector3f another) {

        return x1 * another.x1 + x2 * another.x2 + x3 * another.x3;
    }

    public Vector3f cross(Vector3f another) {

        return new Vector3f(x2 * another.x3 - x3 * another.x2,
                x3 * another.x1 - x1 * another.x3,
                x1 * another.x2 - x2 * another.x1);
    }

    public Vector3f unify() {
        return divide(abs());
    }

    public void print() {
        System.out.println(this);
    }
}
