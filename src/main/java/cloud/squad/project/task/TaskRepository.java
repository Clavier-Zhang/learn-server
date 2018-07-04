package cloud.squad.project.task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {

    Task findByTaskId(String taskId);

    Iterable<Task> findAllByProjectId(String projectId);

    Iterable<Task> findAllByProjectIdAndType(String projectId, String type);

}
