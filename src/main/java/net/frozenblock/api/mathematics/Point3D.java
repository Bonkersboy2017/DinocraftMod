package net.frozenblock.api.mathematics;

import java.io.Serial;
import java.io.Serializable;
/**
 * POINT 3D
 * <p>
 * Same as Java's Point2D, but with 3D coordinates
 * <p>
 * Only for FrozenBlock Modders, ALL RIGHTS RESERVED
 * <p>
 * Allows you to create a 3D point with x, y & z
 *
 * @author      LiukRast (2021-2022)
 * @since 4.0
 *
 */

public abstract class Point3D implements Cloneable {

    /**
     * The {@code Float} class defines a point in 3D space specified in float
     * precision.
     */
    public static class Float extends Point3D implements Serializable {
        public float x;
        public float y;
        public float z;
        public Float() {
        }
        public Float(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX() {
            return (double) x;
        }

        public double getY() {
            return (double) y;
        }

        public double getZ() {
            return (double) z;
        }


        public void setLocation(double x, double y, double z) {
            this.x = (float) x;
            this.y = (float) y;
            this.z = (float) z;
        }

        public void setLocation(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public String toString() {
            return "Point3D.Float["+x+", "+y+", "+z+"]";
        }
    }

    public static class Double extends Point3D implements Serializable {

        public double x;
        public double y;
        public double z;


        public Double() {
        }

        public Double(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        public double getZ() {
            return y;
        }
        public void setLocation(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public String toString() {
            return "Point3D.Double["+x+", "+y+", "+z+"]";
        }
    }

    protected Point3D() {
    }
    public abstract double getX();
    public abstract double getY();
    public abstract double getZ();


    public abstract void setLocation(double x, double y, double z);

    public void setLocation(Point3D p) {
        setLocation(p.getX(), p.getY(), p.getZ());
    }

    public static double distanceSq(double x1, double y1, double z1, double x2, double y2, double z2)
    {
        x1 -= x2;
        y1 -= y2;
        z1 -= z2;
        return (x1 * x1 + y1 * y1 + z1 * z1);
    }

    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2)
    {
        x1 -= x2;
        y1 -= y2;
        z1 -= z2;
        return Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public double distanceSq(double px, double py, double pz) {
        px -= getX();
        py -= getY();
        pz -= getZ();
        return (px * px + py * py + pz * pz);
    }

    public double distanceSq(Point3D pt) {
        double px = pt.getX() - this.getX();
        double py = pt.getY() - this.getY();
        double pz = pt.getZ() - this.getZ();
        return (px * px + py * py + pz * pz);
    }

    public double distance(double px, double py, double pz) {
        px -= getX();
        py -= getY();
        pz -= getZ();
        return Math.sqrt(px * px + py * py + pz * pz);
    }


    public double distance(Point3D pt) {
        double px = pt.getX() - this.getX();
        double py = pt.getY() - this.getY();
        double pz = pt.getZ() - this.getZ();
        return Math.sqrt(px * px + py * py + pz * pz);
    }


    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }


    public int hashCode() {
        long bits = java.lang.Double.doubleToLongBits(getX());
        bits ^= java.lang.Double.doubleToLongBits(getY()) * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }


    public boolean equals(Object obj) {
        if (obj instanceof Point3D) {
            Point3D p2d = (Point3D) obj;
            return (getX() == p2d.getX()) && (getY() == p2d.getY()) && (getZ() == p2d.getZ());
        }
        return super.equals(obj);
    }
}

