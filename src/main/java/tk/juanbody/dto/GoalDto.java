package tk.juanbody.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoalDto {

    private Long id;
    private String name;
    private ExerciseDto exerciseEntity;
    private String description;

    public GoalDto() {

    }

    public GoalDto(Long id, String name, ExerciseDto exerciseEntity, String description) {
        this.id = id;
        this.name = name;
        this.exerciseEntity = exerciseEntity;
        this.description = description;
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

    public ExerciseDto getExerciseEntity() {
        return exerciseEntity;
    }

    public void setExerciseEntity(ExerciseDto exerciseEntity) {
        this.exerciseEntity = exerciseEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
