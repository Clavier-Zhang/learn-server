package cloud.squad.project.task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {
}
