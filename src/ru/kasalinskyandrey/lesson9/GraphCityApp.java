package ru.kasalinskyandrey.lesson9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphCityApp {


    public static void main(String[] args) {
        GraphCityRoad graph = new GraphCityRoad();
        List<City> list = new ArrayList<>();

        String fileName = "C:\\Users\\user\\IdeaProjects\\FirstProject\\src\\ru\\kasalinskyandrey\\lesson9\\1234.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");

                int distance = Integer.parseInt(words[2]);
                String city1 = words[0].toLowerCase();
                String city2 = words[1].toLowerCase();

                Set<City> allCity = graph.getAllNodesSet();
                City cityNode1 = new City(city1);
                City cityNode2 = new City(city2);

                if(!allCity.isEmpty()){
                    for(City city: allCity) {
                    if (city.cityName.equals(city1)) { cityNode1 = city;}
                    if (city.cityName.equals(city2)) { cityNode2 = city;}
                    }
                }

                Road<City, Integer> road = new Road<>(cityNode1, cityNode2, distance);
                graph.addEdge(cityNode1, cityNode2, road);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        graph.addRoadManual("magadan", "ulyanovsk", 110);
        graph.addRoadManualConsole();


        City city = graph.getCity("magadan");
        City cityTo = graph.getCity("Ulyanovsk");

        Map<City, Integer> map = graph.dijkstra(city);
        for(City city2: map.keySet()){
            System.out.println(city2.cityName);
        }
        for (City key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Ключ: " + key.cityName + ", значение: " + value);
        }
        List<City> citys = graph.dijkstra(city, cityTo);
        for(int i = citys.size() - 1; i >= 0 ; i--){
            System.out.print("Город:" + citys.get(i).cityName + ", ");
        }
    }
}
