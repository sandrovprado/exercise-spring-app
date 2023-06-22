package com.sandro.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {

    boolean existsExerciseByName(String name);
    boolean existsExerciseById(Integer id);
}
