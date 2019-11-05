package tk.juanbody.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.juanbody.model.GoalEntity;

@Repository
public interface GoalRepository extends CrudRepository<GoalEntity, Long> {
}
