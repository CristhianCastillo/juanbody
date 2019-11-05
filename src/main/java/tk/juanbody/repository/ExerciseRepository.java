package tk.juanbody.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.juanbody.model.ExerciseEntity;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseEntity, Long> {
}
