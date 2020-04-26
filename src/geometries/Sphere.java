package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

/**
 * class Sphere extends RadialGeometry
 * Sphere with radius and center point
 *    @author marom & haleli
 */

public class Sphere extends RadialGeometry
{
    Point3D _center;

    /**
     * constructor
     * @param radius
     * @param _center
     */
    public Sphere(double radius, Point3D _center) {
        super(radius);
        this._center = _center;
    }

    /**
     * center value getter
     *
     * @return value _center
     */
    public Point3D get_center() {
        return _center;
    }
    /*************** Admin *****************/
    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public Vector getNormal(Point3D point)
    {
        Vector v1=_center.subtract(point);

        return v1.normalize();
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {

       if (ray.getP().equals(this._center))
        {
            Point3D point=new Point3D(_center.add(ray.getVector().scale(_radius)));

            return List.of(point);

        }

        Vector u=new Vector(this._center.subtract(ray.getP()));

        double tm=Util.alignZero(u.dotProduct(ray.getVector()));

        double d=Util.alignZero(Math.sqrt(Util.alignZero(u.lengthSquared()-tm*tm)));
        if(d>this._radius)
        {
            return null;
        }
        double th=Math.sqrt(Util.alignZero((this._radius*this._radius)-d*d));
        if(th==0)
           return null;
        double t1=Util.alignZero(tm+th);
        double t2=Util.alignZero(tm-th);
        Point3D p1 = ray.getPoint(t1);
        Point3D p2 = ray.getPoint(t2);
        if(t1>0&&t2>0)
        {

            return List.of(p1,p2);

        }
        if (t1>0&&t2<=0)
        {
           return List.of(p1);

        }

        if (t2>0 &&t1<=0)
        {
            return List.of(p2);
        }

        return null;

    }
}
