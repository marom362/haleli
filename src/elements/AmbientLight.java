package elements;

import primitives.Color;

public class AmbientLight
{
    private Color _intensity;
    private double _Ka;



    public AmbientLight(Color _intensity, double _Ka) {
        //We did not use K because it is always 1
        this._Ka=1;
        this._intensity = _intensity;
    }

    public void setIntensity(Color _intensity) {
        this._intensity = _intensity;
    }

    public Color GetIntensity()
    {
        return  _intensity;
    }
}
