package com.sandro.exercise;

public record NewExerciseRequest(
        String name,
        String bodyPart,
        Integer reps) {

}
