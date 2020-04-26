package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

/**
 * class Plane implements Geometry
 * Set surface by point vector direction
 *  @author marom & haleli
 */

public class Plane implements Geometry
{

    Point3D _P;
    Vector _normal;

    /**
     * constructor
     * @param _P1
     * @param _P2
     * @param _P3
     *
     * If no surface exists between the three dots throws IllegalArgumentException
     */
    public Plane(Point3D _P1, Point3D _P2,Point3D _P3)
    {
        try {
            Vector vector1=new Vector(_P1.subtract(_P2));
            Vector vector2=new Vector(_P1.subtract(_P3));
            _normal= new Vector((vector1.crossProduct(vector2)).normalized());
        }
        catch (IllegalArgumentException ex)
        {
            throw new IllegalArgumentException("There is no plain that holds the points\n");
        }
        _P=_P1;
    }

    /*************** Admin *****************/
    @Override
    public Vector getNormal(Point3D point)
    {
        return _normal;
    }
    public Vector getNormal() {
        return getNormal(_P);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "Point=" + _P +
                ", normal=" + _normal +
                '}';
    }

    @Override
    public List<Point3D> findIntersections(Ray ray)
    {
        if(this._P.equals(ray.getP()))
            return null;
        double temp= Util.alignZero(ray.getVector().dotProduct(this.getNormal()));

        if (temp==0)
        {
            return null;
        }

        double t = Util.alignZero(this._normal.dotProduct(this._P.subtract(ray.getP())) / temp);

        if(t>0)
        {
            Point3D p=ray.getPoint(t);
            return List.of(p);
        }

        return null;
    }

    public Point3D get_P() {
        return _P;
    }

    public Vector get_normal() {
        return _normal;
    }

}
