package com.sandro.exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseDao {

    List<Exercise> getAllExercises();
    Optional<Exercise> getExerciseById(Integer id);
    void addExercise(Exercise exercise);
    boolean existsExerciseName(String name);
    boolean existsPersonById(Integer id);
    void deleteExerciseById(Integer exerciseId);
    void updateExercise(Exercise update);


}
