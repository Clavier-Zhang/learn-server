package cloud.squad.project.task;


import cloud.common.User.UserRepository;
import cloud.common.User.UserService;
import cloud.returnType.DataForTaskChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    @Resource
    private UserService userService;


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

    public Iterable<DataForTaskChart> dataForTaskChart(String projectId, String type) {

        Iterable<Task> tasks = projectIdToTasksByType(projectId, type);
        List<DataForTaskChart> results = new ArrayList();

        for (Task task : tasks) {
            DataForTaskChart data = new DataForTaskChart();
            data.setTaskKey(task.getTaskKey());
            data.setTitle(task.getTitle());
            data.setContent(task.getContent());
            data.setDate(task.getDate());
            data.setLevel(task.getLevel());
            data.setOwnerName(userService.userIdToUserName(task.getCreatorId()));
            results.add(data);
        }

        return results;
    }

}
