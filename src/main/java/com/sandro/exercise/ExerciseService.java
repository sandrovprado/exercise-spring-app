package com.sandro.exercise;

import com.sandro.exception.DuplicateException;
import com.sandro.exception.RequestValidationExecption;
import com.sandro.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExerciseService {

    private final ExerciseDao exerciseDao;

    public ExerciseService(@Qualifier("jpa") ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    public List<Exercise> getAllExercises() {
        return exerciseDao.getAllExercises();
    }

    public Exercise getExerciseById(Integer id) {
        return exerciseDao.getExerciseById(id)
                .orElseThrow(
                        () -> new ResourceNotFound("Exercise with id [%s] not found".formatted(id))
                );
    }

    public void addExercise(NewExerciseRequest newExerciseRequest) {
        String name = newExerciseRequest.name();
        if (exerciseDao.existsExerciseName(name)) {
            throw new DuplicateException("Exercise already exists!");
        } else {
            Exercise exercise = new Exercise(newExerciseRequest.name(), newExerciseRequest.bodyPart(), newExerciseRequest.reps());
            exerciseDao.addExercise(exercise);
        }
    }

    public void deleteExerciseById(Integer exerciseId){
        if(!exerciseDao.existsPersonById(exerciseId)){
            throw new ResourceNotFound("Exercise with id [%s] not found".formatted(exerciseId));
        }
        exerciseDao.deleteExerciseById(exerciseId);
    }

    public void updateExercise(Integer id,NewExerciseRequest newExerciseRequest){
        Exercise exercise = getExerciseById(id);

        boolean changes = false;
        if(newExerciseRequest.name()!=null && !newExerciseRequest.name().equals(exercise.getName())){
            if(exerciseDao.existsExerciseName(newExerciseRequest.name())){
                throw new DuplicateException("Exercise already exists");
            }
            exercise.setName(newExerciseRequest.name());
            changes = true;
        }
        if(newExerciseRequest.bodyPart()!=null && !newExerciseRequest.bodyPart().equals(exercise.getBodyPart())){
            exercise.setBodyPart(newExerciseRequest.bodyPart());
            changes = true;
        }
        if(newExerciseRequest.reps()!=null && !newExerciseRequest.reps().equals(exercise.getReps())){
            exercise.setReps(newExerciseRequest.reps());
            changes = true;
        }

        if(!changes){
            throw new RequestValidationExecption("No data changes found");
        }

        exerciseDao.updateExercise(exercise);
    }

}
