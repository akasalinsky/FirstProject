package ru.kasalinskyandrey.lesson9;

public class City{
    String cityName;

    City(){}
    City(String cityName){
        this.cityName = cityName;
    }

    String NameToString() {
        return cityName;
    }
}