package com.App.Home.TabLayout.Points;

public class Points {
   private int pointImg;
   private String pointName;
   private String points;

    public Points(int pointImg, String pointName, String points) {
        this.pointImg = pointImg;
        this.pointName = pointName;
        this.points = points;
    }

    public int getPointImg() {
        return pointImg;
    }

    public void setPointImg(int pointImg) {
        this.pointImg = pointImg;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }


}
