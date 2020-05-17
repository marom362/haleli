package renderer;

import elements.Camera;
import geometries.Intersectable;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

import java.util.List;

/**
 * @author marom & haleli
 *class Render -Turns scene into picture
 * attribute : ImageWriter , Scene
 */
public class Render
{
    private ImageWriter _imageWriter;
    private Scene _scene;

    /**
     *constructor
     * @param _imageWriter
     * @param _scene
     */
    public Render(ImageWriter _imageWriter, Scene _scene) {
        this._imageWriter = _imageWriter;
        this._scene = _scene;
    }

    /**
     *The function produces the image from the scene
     */
    public void renderImage()
    {

        Camera camera = _scene.getCamera();
        Intersectable geometries = _scene.getGeometries();
        java.awt.Color background = _scene.getBackground().getColor();
        int nX = _imageWriter.getNx();
        int nY = _imageWriter.getNy();
        double width=_imageWriter.getWidth();
        double height=_imageWriter.getHeight();
        double distance=_scene.getDistance();
        Ray ray;
        //Go through all the pixels
        for (int i = 0; i <nY ; i++)
        {
            for (int j = 0; j <nX ; j++)
            {
                ray = camera.constructRayThroughPixel(nX, nY, j, i, distance, width, height);
                List<Point3D> intersectionPoints = geometries.findIntersections(ray);
                if (intersectionPoints == null)
                    _imageWriter.writePixel(j, i, background);
                else
                {
                    Point3D closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(j, i, calcColor(closestPoint).getColor());

                }
            }
        }

    }

    /**
     *
     * @param p the point in scene
     * @return Returns the color of a particular point
     */
    private Color calcColor(Point3D p)
    {
        return _scene.getAmbientLight().GetIntensity();
    }

    /**
     * @param points
     * @return Returns the closest point to the camera
     */
    public Point3D getClosestPoint(List<Point3D> points)
    {
        Point3D result = null;
        double minDistance=Double.MAX_VALUE;
        Point3D p0=this._scene.getCamera().getP0();
        for (Point3D p:points)
        {
            if(p.distance(p0)<minDistance)
            {
                minDistance=p.distance(p0);
                result=p;
            }
        }
        return result;


    }

    /**
     * Prints a grid over the image
     * @param interval
     * @param color
     */

    public void printGrid(int interval, java.awt.Color color)
    {
        double width=this._imageWriter.getWidth();
        double height=this._imageWriter.getHeight();

        for (int row = 0; row <height ; row++)
        {
            for (int col = 0; col <width ; col++) {
                if (col % interval == 0 || row % interval == 0)
                {
                    _imageWriter.writePixel(row, col, color);
                    _imageWriter.writePixel(col, row, color);
                    
                }
            }

        }
    }

    /**
     * write the scene to image
     */
    public void writeToImage() {

        _imageWriter.writeToImage();

    }


    public ImageWriter get_imageWriter() {
        return _imageWriter;
    }

    public Scene get_scene() {
        return _scene;
    }
}
