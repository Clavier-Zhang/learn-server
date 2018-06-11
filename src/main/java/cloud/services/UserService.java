package cloud.services;

import cloud.entities.User;
import cloud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public void increasePost(String id) {
        User user = userRepository.findById(id);
        int post = user.getPost() + 1;
        userRepository.updatePostById(post, id);
    }

}
