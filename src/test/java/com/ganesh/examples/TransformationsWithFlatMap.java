package com.ganesh.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransformationsWithFlatMap {

    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Mariam", "Alex", "Ismail"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );

    @BeforeEach
    void setUp(){
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() throws Exception {
        List<String> names = new ArrayList<>();
        for(List<String> strings: arrayListOfNames){
            names.addAll(strings);
        }
        System.out.println(names);
    }

    @Test
    public void withFlatMap() throws Exception{
        List<String> names = arrayListOfNames.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(names);
    }

    @Test
    public void flatMapWithOperation() {
        List<Optional<String>> optionals = List.of(
                Optional.of("Code"),
                Optional.of("Always")
        );

        List<String> list = optionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
