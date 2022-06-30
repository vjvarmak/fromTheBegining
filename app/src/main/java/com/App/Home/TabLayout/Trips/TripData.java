package com.App.Home.TabLayout.Trips;

public class TripData {
    int ImageView;
    String Name;
    String Place;

    public int getImageView() {
        return ImageView;
    }

    public void setImageView(int imageView) {
        ImageView = imageView;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public TripData(int imageView, String name, String place) {
        ImageView = imageView;
        Name = name;
        Place = place;
    }


}
