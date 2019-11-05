package tk.juanbody.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PracticeDto {

    private Long id;
    private UserDto userEntity;
    private ExerciseDto exerciseEntity;
    private Double time;
    private GoalDto goalEntity;

    public PracticeDto() {

    }

    public PracticeDto(Long id, UserDto userEntity, ExerciseDto exerciseEntity, Double time, GoalDto goalEntity) {
        this.id = id;
        this.userEntity = userEntity;
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

    public UserDto getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserDto userEntity) {
        this.userEntity = userEntity;
    }

    public ExerciseDto getExerciseEntity() {
        return exerciseEntity;
    }

    public void setExerciseEntity(ExerciseDto exerciseEntity) {
        this.exerciseEntity = exerciseEntity;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public GoalDto getGoalEntity() {
        return goalEntity;
    }

    public void setGoalEntity(GoalDto goalEntity) {
        this.goalEntity = goalEntity;
    }
}
