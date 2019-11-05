package tk.juanbody.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.juanbody.model.PracticeEntity;

@Repository
public interface PracticeRepository extends CrudRepository<PracticeEntity, Long> {
}
