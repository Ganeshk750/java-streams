package com.ganesh.examples;

import com.ganesh.mockdata.MockData;
import com.ganesh.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() throws Exception{
        System.out.println("With for i");
        for(int i = 0; i <= 10; i++){
            System.out.println(i);
        }
        System.out.println("With int stream exclusive");
        IntStream.range(0, 10).forEach(System.out::println);

        System.out.println("With int stream inclusive");
        IntStream.rangeClosed(0,10).forEach(System.out::println);
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception{
        List<Person> people = MockData.getPeople();
        IntStream.range(0,people.size())
                .forEach(index -> {
                    System.out.println(people.get(index));
                });
    }

    @Test
    public void intStreamIterator(){
        IntStream.iterate(0, value -> value + 1)
                .limit(11)
                .forEach(System.out::println);
    }
}
