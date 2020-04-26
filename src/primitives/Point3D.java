package primitives;

import java.util.Objects;


/**
 * Class Point3D Contains three coordinates which makes it a point in space
 * 3 Coordinate
 * @author marom and haleli
 */

public class Point3D {


    Coordinate _x;
    Coordinate _y;
    Coordinate _z;
    /*Static variable, zero point */
    static public Point3D Zero =new Point3D(0,0,0);

    /**
     * constructor
     * @param _x
     * @param _y
     * @param _z
     */
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }

    /**
     * constructor
     * @param _x
     * @param _y
     * @param _z
     */
    public Point3D(double _x, double _y, double _z)
    {
        this._x= new Coordinate( _x);
        this._y =new Coordinate( _y);
        this._z = new Coordinate( _z);
    }


    /**
     * Copy constructor
     * @param point3D
     */
    public Point3D(Point3D point3D) {
        this._x =point3D._x;
        this._y = point3D._y;
        this._z = point3D._z;
    }

    /**
     * Point value getter
     *
     * @return Point value
     */
    public Coordinate get_x() {
        return new Coordinate(_x);
    }

    public Coordinate get_y() {
        return new Coordinate( _y);
    }

    public Coordinate get_z() {
        return new Coordinate( _z);
    }

    public void set_x(Coordinate _x) {
        this._x = new Coordinate(_x);
    }

    public void set_y(Coordinate _y) {
        this._y =new Coordinate( _y);
    }

    public void set_z(Coordinate _z) {
        this._z =new  Coordinate (_z);
    }

    /**
     *
     * @param point3D
     * @return Distance squared of the point with another point
     */
    public double distanceSquared  (Point3D point3D)
    {
        double distanceSquared=
                (this._x._coord - point3D._x._coord)*(this._x._coord - point3D._x._coord)+
                        (this._y._coord - point3D._y._coord)*(this._y._coord - point3D._y._coord)+
                        (this._z._coord - point3D._z._coord)*(this._z._coord - point3D._z._coord);
        return distanceSquared;
    }

    /**
     *
     * @param point3D
     * @return Distance of the point with another point
     */
    public double distance  (Point3D point3D)
    {
        double distance=Math.sqrt(distanceSquared(point3D));
        return distance;
    }

    /**
     *
     * @param point3D
     * @return Vector which is a subtraction of the points
     */
    public Vector subtract(Point3D point3D)
    {
        try {
            Vector vector = new Vector(
                    this._x._coord - point3D._x._coord,
                    this._y._coord - point3D._y._coord,
                    this._z._coord - point3D._z._coord);
            return vector;
        }
        catch (IllegalArgumentException ex)
        {
            throw ex;
        }

    }

    /**
     *
     * @param vector
     * @return Point that is a vector to the current point
     */
    public Point3D add(Vector vector)
    {
        Point3D point3D = new Point3D(
                this._x._coord+vector._head._x._coord,
                this._y._coord+vector._head._y._coord,
                this._z._coord+vector._head._z._coord);
        return point3D;
    }



    /*************** Admin *****************/
    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;

        return Util.isZero(_x.get()- point3D._x.get()) &&
                Util.isZero(_y.get()- point3D._y.get()) &&
                Util.isZero(_z.get()- point3D._z.get());
    }


    @Override
    public int hashCode() {
        return Objects.hash(_x, _y, _z);
    }


    @Override
    public String toString() {
        return "("
                + _x +
                ", " + _y +
                ", " + _z +
                ')';
    }
}
