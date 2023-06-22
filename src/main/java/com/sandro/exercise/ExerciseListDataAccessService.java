package com.sandro.exercise;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class ExerciseListDataAccessService implements ExerciseDao {

    private static List<Exercise> exercises;

    static {
        exercises = new ArrayList<>();
        Exercise bench = new Exercise(1,"Bench","chest",10);
        Exercise squat  = new Exercise(2,"Squat","legs",5);
        Exercise deadlift = new Exercise(3,"Deadlift","back",5);
        exercises.add(bench);
        exercises.add(squat);
        exercises.add(deadlift);


    }

    @Override
    public List<Exercise> getAllExercises() {

        return exercises;
    }

    @Override
    public Optional<Exercise> getExerciseById(Integer id) {
        return exercises.stream().filter(exercise -> exercise.getId().equals(id)).findFirst();
    }

    @Override
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    @Override
    public boolean existsExerciseName(String name) {
        return exercises.stream().anyMatch(exercise -> exercise.getName().equals(name));
    }

    @Override
    public boolean existsPersonById(Integer id) {
        return exercises.stream()
                .anyMatch(exercise -> exercise.getName().equals(id));
    }

    @Override
    public void deleteExerciseById(Integer exerciseId) {
        exercises.stream()
                .filter(exercise -> exercise.getId().equals(exerciseId))
                .findFirst()
                .ifPresent(exercises::remove);
    }

    @Override
    public void updateExercise(Exercise update) {
        exercises.add(update);
    }
}
