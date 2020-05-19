package com.company;

import java.util.Objects;

public class District {

    private String districtName;
    private City districtCenter;
    private double area;

    public District(String districtName, City districtCenter, double area) {
        this.districtName = districtName;
        this.districtCenter = districtCenter;
        this.area = area;
    }

    String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    City getDistrictCenter() {
        return districtCenter;
    }

    public void setDistrictCenter(City districtCenter) {
        this.districtCenter = districtCenter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Double.compare(district.area, area) == 0 &&
                Objects.equals(districtName, district.districtName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(districtName, area);
    }

    @Override
    public String toString() {
        return "District{" +
                "districtName='" + districtName + '\'' +
                ", districtCenter=" + districtCenter +
                ", area=" + area +
                '}';
    }
}
