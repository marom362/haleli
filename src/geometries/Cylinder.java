package geometries;
/**
 * Class Cylinder represents two-Tube Containing hight
 * @author marom & haleli
 */
import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

public class Cylinder extends Tube {
    double _hight;
/*
constructor based
 */
    public Cylinder(double radius, Ray _axisRay, double _hight) {
        super(radius, _axisRay);
        this._hight = _hight;
    }
    /*
       get getNormal
     */
    public Vector getNormal(Point3D point)

    {
        Point3D p0 = get_axisRay().getP();
        Vector v = get_axisRay().getVector();



        // projection of P-O on the ray:
        double t;
        try {
            t = Util.alignZero(point.subtract(p0).dotProduct(v));

        } catch (IllegalArgumentException e) { // P = O
            return v.scale(-1);

        }
        Point3D o;
        if(t!=0) {
             o = p0.add(v.scale(t));
        }

        else
            o=new Point3D(p0);

            Vector normal = point.subtract(o).normalize();

            Point3D p1 = p0.add(v.scale(_hight));


        // if the point is at a base
        if (t == 0 || Util.isZero(_hight - t)) // if it's close to 0, we'll get ZERO vector exception
        {
            //if the point at the base towards the vector
            if(t!=0) {
                //if the point is on the extremity

                if(point.subtract(p1).length()==_radius)
                    try {
                        Vector e= v.add(normal).normalize();

                        return e;
                    }
                    catch (IllegalArgumentException e) {
                        return v;
                    }
                else
                    return v;
            }
            //if the point at the base the lower
            else
            {
                //if the point is on the extremity
                if(point.subtract(p0).length()==_radius)
                    try {
                        Vector e= v.scale(-1).add(normal).normalize();

                        return e;
                    }
                    catch (IllegalArgumentException e) {
                        return v.scale(-1);
                    }
                else
                    return v.scale(-1);

          }
       }



       try {

           return normal;

       }
       catch (IllegalArgumentException e)
       {

           return v;
    }
   }

}
