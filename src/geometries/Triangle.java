package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

/**
 * Triangae extends Polygon
 *  triangle is a private case of a surface that has three points
 *   @author marom & haleli
 */

public class Triangle extends Polygon {
    /**
     * constructor
     * @param P1
     * @param P2
     * @param P3
     */

    public Triangle(Point3D P1,Point3D P2,Point3D P3) {

        super(P1,P2,P3);
    }
    /*************** Admin *****************/
    @Override
    public String toString() {
        return "Triangae{" +
                "_vertices=" + _vertices +
                ", _plane=" + _plane +
                '}';
    }

    @Override
    public List<Point3D> findIntersections(Ray ray)
    {
        List<Point3D> result=this._plane.findIntersections(ray);
        if (result==null)
            return null;
       Vector v1 = this._vertices.get(0).subtract(ray.getP());
       Vector v2 = this._vertices.get(1).subtract(ray.getP());
       Vector v3 = this._vertices.get(2).subtract(ray.getP());

       Vector N1=v1.crossProduct(v2).normalize();
       Vector N2=v2.crossProduct(v3).normalize();

       double t1= Util.alignZero(ray.getVector().dotProduct(N1));
       double t2=Util.alignZero(ray.getVector().dotProduct(N2));

       if(t1==0||t2==0)
           return null;

       if (t1>0)
       {
           if (t2>0)
               return result;
           if(t2<0)
               return null;
       }
        if (t1<0)
        {
            if (t2<0)
                return result;
            if(t2>0)
                return null;
        }
        return null;
    }
}
