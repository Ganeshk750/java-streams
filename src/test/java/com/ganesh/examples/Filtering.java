package com.ganesh.examples;

import com.ganesh.mockdata.MockData;
import com.ganesh.model.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception{
        List<Car> cars = MockData.getCars();

        Predicate<Car> carPredicate = car -> car.getPrice() < 20_000.00;
        Predicate<Car> yellow = car -> car.getColor().equals("Yellow");

        List<Car> carsLessThen20k = cars.stream()
                .filter(carPredicate)
                .filter(yellow)
                .collect(Collectors.toList());

        carsLessThen20k.forEach(System.out::println);
    }

    @Test
    public void dropWhile() throws Exception{
        System.out.println("Using filter");
        Stream.of(2,4,6,8,9,10,12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("Using dropWhile");
        Stream.of(2,4,6,8,9,10,12).dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }


    @Test
    public void takeWhile() throws Exception{
        //Using filter
        System.out.println("Using filter");
        Stream.of(2,4,6,8,9,10,12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("Using take while");
        Stream.of(2,4,6,8,9,10,12).takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void findFirst() throws  Exception{

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n == 50)
                .findFirst()
                .orElse(-1);
        System.out.println(result);
    }

    @Test
    public void allMatch() throws Exception{
        int [] even = {2,4,6,8,10};
        boolean allMatch = Arrays.stream(even).allMatch(n -> n % 2 == 0);
        System.out.println(allMatch);
    }

    @Test
    public void anyMatch() throws Exception{
        int [] evenOrOdd = {2,4,6,8,10,11};
        boolean anyMatch = Arrays.stream(evenOrOdd).anyMatch(n -> !(n % 2 == 0));
        System.out.println(anyMatch);
    }










}
