package ru.kasalinskyandrey.lesson9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphCityApp {

     public static void main(String[] args) throws IOException {
        GraphCityRoad graph = new GraphCityRoad();
        String fileName = "C:\\Users\\user\\IdeaProjects\\FirstProject\\src\\ru\\kasalinskyandrey\\lesson9\\1234.txt";

         graph.getDateFromFile(fileName);

        //graph.addRoadManual("magadan", "ulyanovsk", 110);
        //graph.addRoadManualConsole();

         //Создадим объекты городов для поиска
         City city = graph.getCity("magadan");
         City cityTo = graph.getCity("Ulyanovsk");

        //Получим кратчайшие пути до всех узлов
        Map<City, Integer> map = graph.dijkstra(city);
        //Выведем их на экран
        for(City city2: map.keySet()){
            System.out.println(city2.cityName);
        }
        for (City key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Ключ: " + key.cityName + ", значение: " + value);
        }

        //Получим кратчайший путь до конкретного города
        List<City> citys = graph.dijkstra(city, cityTo);
        //Выведем пууть на экран
        for(int i = citys.size() - 1; i >= 0 ; i--){
            System.out.print("Город:" + citys.get(i).cityName + ", ");
        }
        //Запишем путь в файл
         graph.writeToFile(citys, "C:\\Users\\user\\IdeaProjects\\FirstProject\\src\\ru\\kasalinskyandrey\\lesson9", "321.txt");


     }
}
