package com.ganesh.examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    @Disabled
    void streams(){
        List<String> name = List.of("Ganesh", "Shashi", "Aditya", "Vivek");
        Stream<String> stream = name.stream();

        Stream<String> nameStream = Stream.of("Ganesh", "Shashi", "Aditya", "Vivek");

        long count = stream.limit(2).map(null).sorted(null).dropWhile(null)
                .count();

        String [] namesArray = {};
        Arrays.stream(namesArray);
    }
}
