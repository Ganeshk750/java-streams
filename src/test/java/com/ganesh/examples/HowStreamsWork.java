package com.ganesh.examples;

import com.ganesh.mockdata.MockData;
import com.ganesh.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class HowStreamsWork {

    @Test
    public void understandingCollect() throws Exception{
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(Collectors.toList());
        emails.forEach(System.out::println);
    }

    @Test
    public void intermediateAndTerminalOperations() throws Exception{
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("Filter car "+ car);
                            return car.getPrice() < 10000;
                        })
                        .map(car -> {
                            System.out.println("Mapping car "+ car);
                            return car.getPrice();
                        })
                        .map(price -> {
                            System.out.println("Mapping price "+ price);
                            return price + (price * .15);
                        })
                        .collect(Collectors.toList())
        );
    }
}
