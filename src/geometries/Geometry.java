package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * Interface with getNormal function
 * This interface requires all geometric shapes to realize the function.
 * This gives us uniformity so that we can work with all shapes in a uniform interface.
 * @author marom & haleli
 */

public interface Geometry extends Intersectable
{
    public  Vector getNormal(Point3D point);
}