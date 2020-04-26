package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

/**
 * class Tube
 * @author marom & haleli
 */
public class Tube extends RadialGeometry {
    /**
     * constructor
     *
     * @param radius
     */
    public Ray _axisRay;

    /**
     * constructor
     * @param radius
     * @param _axisRay
     */

    public Tube(double radius, Ray _axisRay) {
        super(radius);
        this._axisRay = _axisRay;
    }

    public Ray get_axisRay() {
        return _axisRay;
    }
    /**
     * getNormal function
     * @param point
     */
    @Override
    public Vector getNormal(Point3D point) {
        Point3D p0 =new Point3D(this._axisRay.getP());
        Vector v = this.get_axisRay().getVector();

        // projection of P-O on the ray:

        double t;
        try {
             t = Util.alignZero(point.subtract(p0).dotProduct(v));

        }

        catch (IllegalArgumentException e) { // P = O
               // t = Util.alignZero(point.subtract(p0).dotProduct(v));
            return v;

        }

            // if the point is at a base
            if (t == 0)// || Util.isZero(height - t)) // if it's close to 0, we'll get ZERO vector exception
              return v;

             Point3D o = p0.add(v.scale(t));
             System.out.println(point.subtract(o));
             return point.subtract(o).normalize();


        //return new Vector(1, 1, 1);
    }
    @Override
    public String toString() {
        return "Tube{" +
                "_axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
