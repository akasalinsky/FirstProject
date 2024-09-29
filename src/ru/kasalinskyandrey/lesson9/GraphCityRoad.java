
package ru.kasalinskyandrey.lesson9;

import java.util.*;

public class GraphCityRoad extends Graph<City, Road extends Edge<City, Integer>> {

    public GraphCityRoad(){
    }

    public GraphCityRoad(Map<City, List<Road<City, Integer>>> graph){
        this.graph = graph;
    }

    GraphCityRoad checkCity (){
        Map<City, List<Road<City, Integer>>> mapCity = this.getAllNodes();
        Map<City, List<Road<City, Integer>>> newMapCity = new HashMap<>();
        Map<String, List<Road<City, Integer>>> cityNameMap = new HashMap<>();
        Set<City> setCity = mapCity.keySet();

        for (City city: setCity){
            if(cityNameMap.containsKey(city.cityName)){
                cityNameMap.get(city.cityName).addAll(mapCity.get(city));
            }
            else {
                newMapCity.put(city, mapCity.get(city));
                cityNameMap.put(city.cityName, mapCity.get(city));
            }
        }
        return new GraphCityRoad(newMapCity);
    }


    public List<City> GetNeighbourCity(String cityName) {
        List<City> neighbourList = new ArrayList<>();
        City city = new City();

        Map<City, List<Road<City, Integer>>> mapCity = this.getAllNodes();
        Set<City> setCity = mapCity.keySet();
        for (City city1: setCity){
            if(city1.cityName.equals(cityName)){ city = city1; }
        }

        List<Road<City, Integer>> roadList = this.getNeighbour(city);

        for(Road<City, Integer> road: roadList){
            if(road.city1.cityName.equals(city.cityName)) {neighbourList.add(road.city2);}
            else neighbourList.add(road.city1);
        }
        return neighbourList;
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

