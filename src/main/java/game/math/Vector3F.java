package game.math;

import java.io.Serializable;

public class Vector3F implements Serializable{

    private double x1;
    private double x2;
    private double x3;

    public enum RoomAxis {

        X_AXIS(new Vector3F(1, 0, 0)),
        Y_AXIS(new Vector3F(0, 1, 0)),
        Z_AXIS(new Vector3F(0, 0, 1));

        private Vector3F v;

        RoomAxis(Vector3F v) {
            this.v = v;
        }

        public Vector3F getV() {
            return v;
        }
    }

    public Vector3F(double[] args) {
        x1 = args[0];
        x2 = args[1];
        x3 = args[2];
    }

    public Vector3F(double x1, double x2, double x3) {
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
        if (!(obj instanceof Vector3F)) {
            return false;
        }

        Vector3F another = (Vector3F) obj;

        return x1 == another.x1 && x2 == another.x2 && x3 == another.x3;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getAngle(Vector3F another) {

        return Math.acos(skalar(another) / (abs() * another.abs()));
    }

    public Vector3F multiply(double d) {
        return new Vector3F(x1 * d, x2 * d, x3 * d);
    }

    public Vector3F divide(double d) {
        return new Vector3F(x1 / d, x2 / d, x3 / d);
    }

    public double abs() {
        return Math.sqrt(x1 * x1 + x2 * x2 + x3 * x3);
    }

    public Vector3F add(Vector3F another) {
        return new Vector3F(x1 + another.x1,
                x2 + another.x2,
                x3 + another.x3);
    }

    public Vector3F subtract(Vector3F another) {
        return new Vector3F(x1 - another.x1,
                x2 - another.x2,
                x3 - another.x3);
    }

    public double skalar(Vector3F another) {

        return x1 * another.x1 + x2 * another.x2 + x3 * another.x3;
    }

    public Vector3F cross(Vector3F another) {

        return new Vector3F(x2 * another.x3 - x3 * another.x2,
                x3 * another.x1 - x1 * another.x3,
                x1 * another.x2 - x2 * another.x1);
    }

    public Vector3F unify() {
        return divide(abs());
    }

    public void print() {
        System.out.println(this);
    }
}
