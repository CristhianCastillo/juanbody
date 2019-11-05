package tk.juanbody.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.juanbody.model.TrainingEntity;

@Repository
public interface TrainingRepository extends CrudRepository<TrainingEntity, Long> {
}
