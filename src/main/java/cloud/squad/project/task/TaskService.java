package cloud.squad.project.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;


    public Task taskIdToTask(String taskId) {
        Task task = taskRepository.findByTaskId(taskId);
        return task;
    }

    public Iterable<Task> projectIdToTasks(String projectId) {
        Iterable<Task> tasks = taskRepository.findAllByProjectId(projectId);
        return tasks;
    }

    public Iterable<Task> projectIdToTasksByType(String projectId, String type) {
        Iterable<Task> tasks = taskRepository.findAllByProjectIdAndType(projectId, type);
        return tasks;
    }

}
