
package ru.kasalinskyandrey.lesson9;

import java.util.*;

public class GraphCityRoad extends Graph<City, Road<City, Integer>> {

    public GraphCityRoad(){
    }

    public GraphCityRoad(Map<City, List<Road<City, Integer>>> graph){
        this.graph = graph;
    }

    public City getCity(String cityName){
        for (City node : graph.keySet()) {
            if(node.NameToString().equals(cityName.toLowerCase()))
                return node;
        }
        return null;
    }

    public void addRoadManual(String cityOne, String cityTwo, Integer distance) {
        City cityOneObject = new City(cityOne.toLowerCase());
        City cityTwoObject = new City(cityTwo.toLowerCase());
        Set<City> allCity = this.getAllNodesSet();
        if(!allCity.isEmpty()){
            for(City city: allCity) {
                if (city.cityName.equals(cityOne)) { cityOneObject = city;}
                if (city.cityName.equals(cityTwo)) { cityTwoObject = city;}
            }
        }
        Road<City, Integer> road = new Road<>(cityOneObject, cityTwoObject, distance);
        this.addEdge(cityOneObject, cityTwoObject, road);
    }

    public void addRoadManualConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a city One: ");
        String cityOne = in.nextLine();

        System.out.print("Input a city Two: ");
        String cityTwo = in.nextLine();

        System.out.print("Input a distance: ");
        int distance = in.nextInt();

        City cityOneObject = new City(cityOne.toLowerCase());
        City cityTwoObject = new City(cityTwo.toLowerCase());
        Set<City> allCity = this.getAllNodesSet();
        if(!allCity.isEmpty()){
            for(City city: allCity) {
                if (city.cityName.equals(cityOne)) { cityOneObject = city;}
                if (city.cityName.equals(cityTwo)) { cityTwoObject = city;}
            }
        }
        Road<City, Integer> road = new Road<>(cityOneObject, cityTwoObject, distance);

        this.addEdge(cityOneObject, cityTwoObject, road);

    }

    @Override
    public void print() {
        Map<City, List<Road<City, Integer>>> mapCity = this.getAllNodes();
        Set<City> setCity = mapCity.keySet();

        for (City city : setCity) {
            System.out.print(city.cityName);
            System.out.print(":   ");
            for(Road<City, Integer> road: mapCity.get(city)){
                System.out.print("!!!city1: " + road.city1.cityName + "; city2: " + road.city2.cityName + "; distance: " + road.distance + ". ");
            }
            System.out.println();
        }
    }
}

