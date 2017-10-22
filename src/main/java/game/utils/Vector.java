package game.utils;

public class Vector {

    private double x1;
    private double x2;

    public enum Axis {

        X_AXIS(new Vector(1, 0)),
        Y_AXIS(new Vector(0, 1));

        private Vector v;

        Axis(Vector v) {
            this.v = v;
        }

        public Vector getV() {
            return v;
        }
    }

    public Vector(double[] args) {
        x1 = args[0];
        x2 = args[1];
    }

    public Vector(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "[ " + x1 + " | " + x2 + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector)) {
            return false;
        }

        Vector another = (Vector) obj;

        return x1 == another.x1 && x2 == another.x2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }


    public double getAngle(Vector another) {

        return Math.acos(skalar(another) / (abs() * another.abs()));
    }

    public Vector multiply(double d) {
        return new Vector(x1 * d, x2 * d);
    }

    public Vector divide(double d) {
        return new Vector(x1 / d, x2 / d);
    }

    public double abs() {
        return Math.sqrt(x1 * x1 + x2 * x2);
    }

    public Vector sum(Vector another) {
        return new Vector(x1 + another.x1,
                x2 + another.x2);
    }

    public Vector subtract(Vector another) {
        return new Vector(x1 - another.x1,
                x2 - another.x2);
    }

    public double skalar(Vector another) {

        return x1 * another.x1 + x2 * another.x2;
    }

    public Vector unify() {
        return divide(abs());
    }

    public void print() {
        System.out.println(this);
    }
}
