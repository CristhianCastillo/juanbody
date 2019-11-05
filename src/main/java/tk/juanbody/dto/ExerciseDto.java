package tk.juanbody.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExerciseDto {

    private Long id;
    private String name;
    private MuscleDto muscleEntity;
    private String description;
    private TrainingDto trainingEntity;
    private List<GoalDto> goalEntities;

    public ExerciseDto() {

    }

    public ExerciseDto(Long id, String name, MuscleDto muscleEntity, String description, TrainingDto trainingEntity, List<GoalDto> goalEntities) {
        this.id = id;
        this.name = name;
        this.muscleEntity = muscleEntity;
        this.description = description;
        this.trainingEntity = trainingEntity;
        this.goalEntities = goalEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MuscleDto getMuscleEntity() {
        return muscleEntity;
    }

    public void setMuscleEntity(MuscleDto muscleEntity) {
        this.muscleEntity = muscleEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrainingDto getTrainingEntity() {
        return trainingEntity;
    }

    public void setTrainingEntity(TrainingDto trainingEntity) {
        this.trainingEntity = trainingEntity;
    }

    public List<GoalDto> getGoalEntities() {
        return goalEntities;
    }

    public void setGoalEntities(List<GoalDto> goalEntities) {
        this.goalEntities = goalEntities;
    }
}
