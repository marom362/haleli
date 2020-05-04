package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

/**
 * Class Camera Simulates a camera with 3 vectors and a center point
 *3 vectors vertical and point center
 * @author marom & haleli
 */
public class Camera {
    Point3D p0;
    Vector vUp;
    Vector vTo;
    Vector vRight;


    public Camera(Point3D p0, Vector vto, Vector vup) {

        this.p0 = p0;
        if(vup.dotProduct(vto)!=0) //if vTo and vUp are not vertical
        {
            throw new IllegalArgumentException("the vector are not vertical");
        }
        vUp=vup.normalize();
        vTo=vto.normalize();
        //the vector vRight is vertical to vTo and vUp
        vRight=vTo.crossProduct(vUp);

    }

   /*
     construct Ray Through Pixel
  */
    public Ray constructRayThroughPixel (int nX, int nY,
                                         int j, int i, double screenDistance,
                                         double screenWidth, double screenHeight)
    {
        //Image center
        Point3D pC=this.p0.add(this.vTo.scale(screenDistance));

        //Ratio (pixel width & height)
        double rY=screenHeight/nY;
        double rX=screenWidth/nX;


       // Pixel[i,j] center
        double yI= Util.alignZero((i-(double)nY/2)*rY+rY/2);
        double xJ=Util.alignZero((j-(double)nX/2)*rX+rX/2);
        Point3D pIJ=pC;
        if(xJ!=0)
            pIJ=pIJ.add(vRight.scale(xJ));
        if(yI!=0)
            pIJ=pIJ.add(vUp.scale(-yI));



        Ray ray=new Ray(p0,pIJ.subtract(p0).normalize());

        return ray;

    }

    public Point3D getP0() {
        return p0;
    }

    public Vector getvUp() {
        return vUp;
    }

    public Vector getvTo() {
        return vTo;
    }

    public Vector getvRight() {
        return vRight;
    }
}
