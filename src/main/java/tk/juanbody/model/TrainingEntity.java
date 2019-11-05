package tk.juanbody.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "training")
public class TrainingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "trainingEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExerciseEntity> exerciseEntities;

    public TrainingEntity() {

    }

    public TrainingEntity(Long id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public TrainingEntity(Long id, String name, Boolean status, List<ExerciseEntity> exerciseEntities) {
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

    public List<ExerciseEntity> getExerciseEntities() {
        if (exerciseEntities != null) {
            List<ExerciseEntity> result = new ArrayList<>();
            for (ExerciseEntity exerciseEntity : exerciseEntities) {
                result.add(new ExerciseEntity(exerciseEntity.getId(), exerciseEntity.getName(), exerciseEntity.getMuscleEntity(), exerciseEntity.getDescription(), exerciseEntity.getGoalEntities()));
            }
            return result;
        } else {
            return null;
        }
    }

    public void setExerciseEntities(List<ExerciseEntity> exerciseEntities) {
        this.exerciseEntities = exerciseEntities;
    }
}
