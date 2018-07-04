package cloud.squad.project.task;


import cloud.common.BaseController;
import cloud.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TaskController extends BaseController {


    @Autowired
    private TaskRepository taskRepository;

    @Resource
    private TaskService taskService;

    @PostMapping("/task/all")
    public Result all(HttpServletRequest request) {
        Iterable<Task> all = taskRepository.findAll();
        return new Result("success", "all tasks", all);
    }
}
