package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Country {
    private String countryName;
    private City capital;
    private ArrayList<Region> regions;

    Country(String countryName, City capital) {
        this.countryName = countryName;
        this.capital = capital;
        this.regions = new ArrayList<>();
    }


    //вывести на консоль количество областей.
    void printNumberOfRegions() {
        System.out.printf("Количество областей - %d  в %s.\n", this.regions.size(), countryName);
    }

   // вывести на консоль столицу.
    void printCapital() {
        System.out.printf("В %s  столица - %s.\n", countryName, capital);
    }

    // вывести на консоль площадь.

    void printArea() throws Exception {
        try {
            double area = 0;
            for (Region region : regions) {
                area += region.getArea();
                if (area < 0) {
                    // обработка ошибок, связанных с корректностью выполнения математических операций
                    throw new Exception("Площадь должна быть больше нуля.");
                }
            }
            System.out.printf("Площадь %s составлет %.3f тысячи квадратных километров.\n", countryName, area);
        }
        catch (Exception ex){

            System.out.println(ex.getMessage());
        }
    }

   // вывести на консоль областные центры.
    void printRegionCenters () {
        System.out.printf("Региональные центры %s: ", countryName);
        for (Region region : regions) {
            System.out.print(region.getRegionalName() + ", ");
        }
        System.out.println("\b\b.");
    }

    void addRegion (Region region) {
        regions.add(region);
    }

    void removeRegion (String regionName) {
        for (Region region : regions) {
            if (regionName.equals(region.getRegionalName())) {
                regions.remove(region);
            }
        }
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(countryName, country.countryName) &&
                Objects.equals(capital, country.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, capital);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", capital=" + capital +
                ", regions=" + regions +
                '}';
    }


    //поиск государства по столице
    public static void searchCity() throws IOException {

        try {
            List<Country> tempCountrysCity = InOutFile.inFile();
            Scanner in = new Scanner(System.in);
            System.out.print("Введите название столицы для поиска объекта в файле: ");
            String cityName = in.nextLine();
            //проверка на недопустимое значение поля (имя столийцы не должно содержать цифры)
            if(cityName.matches(".*\\d.*"))
                throw new Exception("Имя не должно содержать цифры!!!\n");
            for (Country country : tempCountrysCity) {
                if (country.getCapital().getName().equalsIgnoreCase(cityName)) { //равнение имен города без учета регистра
                    System.out.print(country.toString() + "\n");
                    return;
                }

            }
            System.out.print("Государства с такой столицей не найдено! \n");
        }catch (Exception ex){
            System.out.print(ex.getMessage());
        }


    }
}
