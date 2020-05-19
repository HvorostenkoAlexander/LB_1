package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Region {
    private String regionalName;
    private City regionalCenter;
    private double area; //kkm
    private ArrayList<District> districts;

    Region(String regionalName, City regionalCenter, double area) {
        this.regionalName = regionalName;
        this.regionalCenter = regionalCenter;
        this.area = area;
        this.districts = new ArrayList<>();
    }

    double getArea() {
        return area;
    }

    public void setRegionalName(String regionalName) {
        this.regionalName = regionalName;
    }

    public void setArea(double area) {
        this.area = area;
    }

    int getPopulation () {
        int population = 0;
        for (District district : this.districts) {
            population += district.getDistrictCenter().getPopulation();
        }
        return population;
    }

    void addDistrict (District district) {
        districts.add(district);
    }

    void removeDistrict (String districtName) {
        for (District district : districts) {
            if (districtName.equals(district.getDistrictName())) {
                districts.remove(district);
            }
        }
    }

    City getRegionalCenter() {
        return regionalCenter;
    }

    void setRegionalCenter(City regionalCenter) {
        this.regionalCenter = regionalCenter;
    }

    ArrayList<District> getDistricts() {
        return districts;
    }

    void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }

    String getRegionalName() {
        return regionalName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Double.compare(region.area, area) == 0 &&
                Objects.equals(regionalName, region.regionalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionalName, area);
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionalName='" + regionalName + '\'' +
                ", regionalCenter=" + regionalCenter +
                ", area=" + area +
                ", districts=" + districts +
                '}';
    }
}
