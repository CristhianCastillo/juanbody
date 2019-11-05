package tk.juanbody.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.juanbody.model.MuscleEntity;

@Repository
public interface MuscleRepository extends CrudRepository<MuscleEntity, Long> {
}
