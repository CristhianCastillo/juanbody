package tk.juanbody.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "practice")
public class PracticeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private ExerciseEntity exerciseEntity;
    @Column(nullable = false, name = "time")
    private Double time;
    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = true)
    private GoalEntity goalEntity;

    public PracticeEntity() {

    }

    public PracticeEntity(Long id, UserEntity userEntity, ExerciseEntity exerciseEntity, Double time, GoalEntity goalEntity) {
        this.id = id;
        this.userEntity = userEntity;
        this.exerciseEntity = exerciseEntity;
        this.time = time;
        this.goalEntity = goalEntity;
    }

    public PracticeEntity(Long id, ExerciseEntity exerciseEntity, Double time, GoalEntity goalEntity) {
        this.id = id;
        this.exerciseEntity = exerciseEntity;
        this.time = time;
        this.goalEntity = goalEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ExerciseEntity getExerciseEntity() {
        return exerciseEntity;
    }

    public void setExerciseEntity(ExerciseEntity exerciseEntity) {
        this.exerciseEntity = exerciseEntity;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public GoalEntity getGoalEntity() {
        return goalEntity;
    }

    public void setGoalEntity(GoalEntity goalEntity) {
        this.goalEntity = goalEntity;
    }
}
