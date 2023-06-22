package com.sandro.exercise;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Exercise {

    @Id
    @SequenceGenerator(name = "exercise_id_sequence",sequenceName = "exercise_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "exercise_id_sequence")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String bodyPart;
    @Column(nullable = false)
    private Integer reps;



    public Exercise(){}

    public Exercise(Integer id, String name, String bodyPart, Integer reps) {
        this.id = id;
        this.name = name;
        this.bodyPart = bodyPart;
        this.reps = reps;
    }

    public Exercise(String name, String bodyPart, Integer reps) {
        this.name = name;
        this.bodyPart = bodyPart;
        this.reps = reps;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public Integer getReps() {
        return reps;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id) && Objects.equals(name, exercise.name) && Objects.equals(bodyPart, exercise.bodyPart) && Objects.equals(reps, exercise.reps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bodyPart, reps);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bodyPart='" + bodyPart + '\'' +
                ", reps=" + reps +
                '}';
    }
}
