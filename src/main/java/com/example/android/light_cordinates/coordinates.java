package com.example.android.light_cordinates;

public class coordinates {
    private Double lat;
    private Double lng;

    coordinates()
    {
        lat=0.0;
        lng=0.0;
    }
    coordinates(Double latd,Double lngd)
    {
        lat=latd;
        lng=lngd;
    }
    public Double getlat(){return lat;}
    public Double getlng(){return lng;}
    public void setlat(Double l){lat=l;}
    public void setlng(Double d){lng=d;}
}
