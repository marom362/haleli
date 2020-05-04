package geometries;

import primitives.Point3D;

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
}
