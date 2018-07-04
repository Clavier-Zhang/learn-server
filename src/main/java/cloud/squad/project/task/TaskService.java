package cloud.squad.project.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;


}
