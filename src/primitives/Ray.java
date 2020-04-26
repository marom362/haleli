package primitives;

import java.util.Objects;
/**
 * Class Ray
 * Point3D & vector
 *
 * @author marom & haleli
 */

public class Ray
{

    Point3D p;
    Vector vector;


    public Ray(Point3D p, Vector vector) {
        if(!Util.isZero(vector.length()-1))
        {
            System.out.println(vector.length());
            throw new IllegalArgumentException("the vector is not normalize");
        }

        this.p = new Point3D(p);
        this.vector = new Vector(vector);
    }

    public Point3D getP() {
        return p;
    }


    public Vector getVector() {
        return vector;
    }
    public  Point3D getPoint(double t)
     {
         if (t==0)
             return this.getP();
         Point3D P=this.getP().add(this.getVector().scale(t));
         return P;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(p, ray.p) &&
                Objects.equals(vector, ray.vector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, vector);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "p=" + p +
                ", vector=" + vector +
                '}';
    }


}
