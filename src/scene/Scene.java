package scene;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

/**
 @author marom & haleli
  *class Scene-
 Contains all the elements of the scene
  * attribute : String, Color _background ,AmbientLight ,Geometries , double _distance
  */
public class Scene
{
    private   String _name ;
    private  Color _background;
    private  AmbientLight _ambientLight;
    private  Geometries _geometries;
    private  Camera _camera;
    private  double _distance;

    /**
     * constructor
     * @param _name
     */
    public Scene(String _name) {
        this._name = _name;
        this._geometries=new Geometries();
           }
   //********************get**********************

    public String getName() {
        return _name;
    }

    public Color getBackground() {
        return _background;
    }

    public AmbientLight getAmbientLight() {
        return _ambientLight;
    }

    public Geometries getGeometries() {
        return _geometries;
    }

    public Camera getCamera() {
        return _camera;
    }

    public double getDistance() {
        return _distance;
    }

  //  **************set***************
    public void setBackground(Color _background) {
        this._background = _background;
    }

    public void setAmbientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public void setCamera(Camera _camera) {
        this._camera = _camera;
    }

    public void setDistance(double _distance) {
        this._distance = _distance;
    }

    /**
     * add geometries to scene
     * @param geometries
     */
    public void addGeometries(Intersectable... geometries)
    {
        this._geometries.add(geometries);


    }
}


