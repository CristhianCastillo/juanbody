package tk.juanbody.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercise")
public class ExerciseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "muscle_id", nullable = false)
    private MuscleEntity muscleEntity;
    @Column(nullable = false, name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private TrainingEntity trainingEntity;
    @OneToMany(mappedBy = "exerciseEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GoalEntity> goalEntities;

    public ExerciseEntity() {

    }

    public ExerciseEntity(Long id, String name, MuscleEntity muscleEntity, String description, TrainingEntity trainingEntity) {
        this.id = id;
        this.name = name;
        this.muscleEntity = muscleEntity;
        this.description = description;
        this.trainingEntity = trainingEntity;
    }

    public ExerciseEntity(Long id, String name, MuscleEntity muscleEntity, String description, List<GoalEntity> goalEntities) {
        this.id = id;
        this.name = name;
        this.muscleEntity = muscleEntity;
        this.description = description;
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

    public MuscleEntity getMuscleEntity() {
        return muscleEntity;
    }

    public void setMuscleEntity(MuscleEntity muscleEntity) {
        this.muscleEntity = muscleEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TrainingEntity getTrainingEntity() {
        return trainingEntity;
    }

    public void setTrainingEntity(TrainingEntity trainingEntity) {
        this.trainingEntity = trainingEntity;
    }

    public List<GoalEntity> getGoalEntities() {
        if (goalEntities != null) {
            List<GoalEntity> result = new ArrayList<>();
            for (GoalEntity goalEntity : goalEntities) {
                result.add(new GoalEntity(goalEntity.getId(), goalEntity.getName(), goalEntity.getDescription()));
            }
            return result;
        } else return null;
    }

    public void setGoalEntities(List<GoalEntity> goalEntities) {
        this.goalEntities = goalEntities;
    }
}
