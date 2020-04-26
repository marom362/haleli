package geometries;


/**
 *  abstract class Used as a parent for radiused shapes
 *   @author marom & haleli
 */
public abstract class RadialGeometry implements Geometry{

    double _radius;

    /**
     * constructor
     * @param _radius
     */



    public RadialGeometry(double _radius) {
        if(_radius==0)
            throw new IllegalArgumentException("radius can't be zero");
        this._radius = _radius;
    }

    /**
     *radius value getter
     *
     * @return value _radius
     */

    public double getRadius() {
        return _radius;
    }

}
