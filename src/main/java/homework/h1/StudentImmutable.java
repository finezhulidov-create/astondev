package homework.h1;

import java.util.List;

public final class StudentImmutable {
    private  final String course;
    private  final Integer estimation;
    private  final Human human ;


    public StudentImmutable(String course, Integer estimation, Human human) {
        this.course = course;
        this.estimation = estimation;
        this.human = human;
    }

    public String getCourse() {
        return course;
    }

    public Integer getEstimation() {
        return estimation;
    }

    public Human getHuman() {
        return human != null ? human.copy() : null ;
    }

    @Override
    public String toString() {
        return "StudentImmutable{" +
                "course='" + course + '\'' +
                ", estimation=" + estimation +
                ", human=" + human +
                '}';
    }
}
