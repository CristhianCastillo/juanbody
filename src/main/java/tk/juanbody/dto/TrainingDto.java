package tk.juanbody.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainingDto {

    private Long id;
    private String name;
    private Boolean status;
    private List<ExerciseDto> exerciseEntities;

    public TrainingDto() {

    }

    public TrainingDto(Long id, String name, Boolean status, List<ExerciseDto> exerciseEntities) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.exerciseEntities = exerciseEntities;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<ExerciseDto> getExerciseEntities() {
        return exerciseEntities;
    }

    public void setExerciseEntities(List<ExerciseDto> exerciseEntities) {
        this.exerciseEntities = exerciseEntities;
    }
}
