package primitives;

import java.util.Objects;
/**
 * Class Vector
 * point3D _head
 *
 * @author marom & haleli
 */

public class Vector {



    Point3D _head;

    /**
     * constructor for Vector
     * @param _head
     */
    public Vector( Point3D _head) {
        if (_head.equals(Point3D.Zero))
            throw new IllegalArgumentException("this values are unable for a vector");
        this._head = _head;
    }

    /**
     * constructor for Vector
     * @param _x
     * @param _y
     * @param _z
     */
    public Vector(Coordinate _x,Coordinate _y, Coordinate _z)
    {
        if(_x._coord==0 &&_y._coord==0 && _z._coord==0)
            throw new IllegalArgumentException("/this values are unable for a vector");
        this._head._x =_x;
        this._head._y=_y;
        this._head._z=_z;
    }

    public Vector(double _x,double _y, double _z)
    {
        if(_x==0 &&_y==0 && _z==0)
            throw new IllegalArgumentException("//this values are unable for a vector");
        this._head= new Point3D(_x, _y, _z);
    }
    /**
     * copy constructor for Vector
     * @param vector
     */
    public Vector(Vector vector) {
        this._head = vector._head;
    }

    /**
     * add
     * @param vector
     * @return newVector: Adding a vector coordinate with another vector coordinate
     */
    public Vector add (Vector vector)
    {
        Vector newVector= new Vector(
                this._head._x._coord+vector._head._x._coord,
                this._head._y._coord+vector._head._y._coord,
                this._head._z._coord+vector._head._z._coord);
        return newVector;
    }

    /**
     *Subtract
     * @param vector
     * @return newVector:Subtract a vector coordinate with another vector coordinate
     */
    public Vector subtract ( Vector vector)
    {
        Vector newVector= new Vector(
                this._head._x._coord-vector._head._x._coord,
                this._head._y._coord-vector._head._y._coord,
                this._head._z._coord-vector._head._z._coord);
        return newVector;
    }

    /**
     *scale
     * @param scler
     * @return vector: Multiplying each of the coordinates by scalar
     *
     */
    public Vector scale(double scler)
    {
        Vector vector= new Vector(
                this._head._x._coord*scler,
                this._head._y._coord*scler,
                this._head._z._coord*scler);
        return vector;

    }

    /**
     *
     * @param vector
     * @return dot Product :
     */
    public double dotProduct(Vector vector)
    {
        double scler =this._head._x._coord*vector._head._x._coord
                +this._head._y._coord*vector._head._y._coord
                +this._head._z._coord*vector._head._z._coord;
        return  scler;
    }

    /**
     *
     * @param vector
     * @return cross Product
     */
    public Vector crossProduct(Vector vector)
    {

        try {
            Vector newVector = new Vector(
                    this._head._y._coord * vector._head._z._coord - this._head._z._coord * vector._head._y._coord,
                    this._head._z._coord *vector._head._x._coord - this._head._x._coord * vector._head._z._coord ,
                    this._head._x._coord * vector._head._y._coord - this._head._y._coord * vector._head._x._coord);
            return newVector;
        }
        catch(IllegalArgumentException ex)
        {
            throw  ex;
        }
    }

    /**
     *
     * @return length Squared
     */
    public double lengthSquared()
    {
        return  this._head.distanceSquared((Point3D.Zero));
    }

    /**
     *
     * @return length
     */
    public double length()
    {
        double  sqrt= Math.sqrt(lengthSquared());
        return sqrt;
    }

    /**
     *
     * @return  Vector normalization by difference in length
     */
    public Vector normalize()
    {
        double length=this.length();
        Coordinate coordinate=new Coordinate(this._head._x._coord/length);
        this._head._x= coordinate;
        coordinate=new Coordinate(this._head._y._coord/length);
        this._head._y=coordinate;
        coordinate=new Coordinate(this._head._z._coord/length);
        this._head._z=coordinate;
        return this;
    }

    /**
     *
     * @return new vector:  Vector normalization by difference in length
     */
    public  Vector normalized()
    {
        Vector vector = new Vector(this);
        return vector.normalize();
    }
    /*************** Admin *****************/
    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(_head, vector._head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_head);
    }

    public Point3D get_head() {
        return _head;
    }
}
