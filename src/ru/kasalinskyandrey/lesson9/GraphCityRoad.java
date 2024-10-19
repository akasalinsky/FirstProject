
package ru.kasalinskyandrey.lesson9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphCityRoad extends Graph<City, Road<City, Integer>> {

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

    public void getDateFromFile(String fileInputName){
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileInputName), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");

                int distance = Integer.parseInt(words[2]);
                String city1 = words[0].toLowerCase();
                String city2 = words[1].toLowerCase();

                Set<City> allCity = this.getAllNodesSet();
                City cityNode1 = new City(city1);
                City cityNode2 = new City(city2);

                if(!allCity.isEmpty()){
                    for(City city: allCity) {
                        if (city.cityName.equals(city1)) { cityNode1 = city;}
                        if (city.cityName.equals(city2)) { cityNode2 = city;}
                    }
                }

                Road<City, Integer> road = new Road<>(cityNode1, cityNode2, distance);
                this.addEdge(cityNode1, cityNode2, road);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public void writeToFile(List<City> cityList, String directory, String filename) throws IOException{
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(directory, filename))) {
                writer.write("(Город отправления) " + cityList.get(cityList.size()-1).cityName);

                for(int i = cityList.size()-2; i >= 0; i--){
                    City currentCity = cityList.get(i);
                    int distanse = this.getEdge(currentCity, cityList.get(i+1)).getWeight();

                    writer.write(" ---" + distanse + "км.--> " + currentCity.cityName);
                }
                writer.write(" (город назначения)");

            }
        }

}

