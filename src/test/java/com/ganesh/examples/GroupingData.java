package com.ganesh.examples;

import com.ganesh.mockdata.MockData;
import com.ganesh.model.Car;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception{
        Map<String, List<Car>> map = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));
        map.forEach((s, cars) ->{
            System.out.println("Make "+ s);
            cars.forEach(System.out::println);
            System.out.println("-----------------------");
        });
    }
}
