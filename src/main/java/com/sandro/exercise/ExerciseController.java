package com.sandro.exercise;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping()
    public List<Exercise> getExercises(){
        return exerciseService.getAllExercises();
    }

    @GetMapping("{exerciseId}")
    public Exercise getExerciseById(@PathVariable("exerciseId")Integer id){
        return exerciseService.getExerciseById(id);
    }

    @PostMapping()
    public void addExercise(@RequestBody NewExerciseRequest request){
        exerciseService.addExercise(request);
    }

    @DeleteMapping("{exerciseId}")
    public void deleteExerciseById(@PathVariable("exerciseId")Integer exerciseId){
        exerciseService.deleteExerciseById(exerciseId);
    }

    @PutMapping("{exerciseId}")
    public void updateExercise(@PathVariable("exerciseId") Integer id,@RequestBody NewExerciseRequest request){
        exerciseService.updateExercise(id,request);
    }

}
