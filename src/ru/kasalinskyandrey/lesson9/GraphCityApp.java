package ru.kasalinskyandrey.lesson9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphCityApp {
    public static void main(String[] args) {
        GraphCityRoad graph = new GraphCityRoad();
        List<City> list = new ArrayList<>();

        String fileName = "C:\\Users\\user\\IdeaProjects\\FirstProject\\src\\ru\\kasalinskyandrey\\lesson9\\1234.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        /*try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) {
                String line = br.readLine();
                String[] words = line.split(",");

                int distance = Integer.parseInt(words[2]);
                City city1 = new City(words[0].toLowerCase());
                City city2 = new City(words[1].toLowerCase());

                Road<City, Integer> road = new Road<>(city1, city2, distance);
                graph.addEdge(city1, city2, road);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }*/
        graph = graph.checkCity();
        list = graph.GetNeighbourCity("magadan");

        System.out.println("magadan:");
        for(City city: list) {
            System.out.println(city.cityName);
        }

    }
}
