package com.sandro.exercise;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("jpa")
public class ExerciseJPADataAccessService implements ExerciseDao {

    private final ExerciseRepository exerciseRepository;

    public ExerciseJPADataAccessService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @Override
    public Optional<Exercise> getExerciseById(Integer id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public void addExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public boolean existsExerciseName(String name) {
        return exerciseRepository.existsExerciseByName(name);
    }

    @Override
    public boolean existsPersonById(Integer id) {
        return exerciseRepository.existsExerciseById(id);
    }

    @Override
    public void deleteExerciseById(Integer exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }

    @Override
    public void updateExercise(Exercise update) {
        exerciseRepository.save(update);
    }
}
