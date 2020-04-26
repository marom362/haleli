package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.*;
/**
 * class Geometries implements Intersectable
 * Contains a list of geometries
 *  @author marom & haleli
 */

public class Geometries implements Intersectable {

    private List<Intersectable> _geometriesList;

    public Geometries()
    {
        _geometriesList= new ArrayList<Intersectable>();
    }
    public Geometries(Intersectable... geometries)
    {
        _geometriesList=List.of(geometries);
    }
    public void add(Intersectable... geometries) {

        List<Intersectable> temp = List.of(geometries);
        _geometriesList.addAll(temp);
    }
    //Execute the action for the entire list of geometries.
    @Override
    public List<Point3D> findIntersections(Ray ray) {

        List<Point3D> list=new ArrayList<Point3D>();
        for (int i = 0; i <this.get_geometriesList().size() ; i++)
        {
            List<Point3D> result=this._geometriesList.get(i).findIntersections(ray);
            if(result!=null)
                list.addAll(result);

        }
        if(list.isEmpty())
            return null;
        return list;
    }

    public List<Intersectable> get_geometriesList() {
        return _geometriesList;
    }
}
