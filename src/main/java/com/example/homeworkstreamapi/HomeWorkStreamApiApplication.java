package com.example.homeworkstreamapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class HomeWorkStreamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeWorkStreamApiApplication.class, args);

        findMinMax(Stream.of(1, 3, 6),Integer::compareTo, (min, max) ->{
            System.out.println( "min " + min + "\nmax " + max);
        });
        evenNumber();
    }
//Задание1
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }

    //Задание 2

    public static void evenNumber(){
        Stream.iterate(2, i-> i + 2).limit(10).forEach(System.out::println);

    }
}

