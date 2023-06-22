package com.sandro;

import com.sandro.exercise.Exercise;
import com.sandro.exercise.ExerciseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(ExerciseRepository exerciseRepository){
        return args -> {
            Exercise squat = new Exercise("Squat","legs",5);
            Exercise bench = new Exercise("Bench","chest",10);
            Exercise deadlift = new Exercise("Deadlift","back",3);

            List<Exercise> exercises = List.of(squat,bench,deadlift);
            exerciseRepository.saveAll(exercises);
        };

        }

}
