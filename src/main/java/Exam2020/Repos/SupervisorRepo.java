package Exam2020.Repos;

import Exam2020.Models.Supervisor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepo extends CrudRepository<Supervisor, Long> {
}
