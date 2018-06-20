package cloud.controllers;


import cloud.entities.Result;
import cloud.entities.User;
import cloud.repositories.FollowRepository;
import cloud.repositories.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "User", description = "User operations")
public class UserController extends BaseController{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowRepository followRepository;


    @GetMapping("/user/all")
    public Iterable<User> all(HttpServletRequest request) {
        return userRepository.findAll();
    }

    @GetMapping("/user/deleteAll")
    public Result deleteAll(HttpServletRequest request) {
        userRepository.deleteAll();
        return new Result("success");
    }

    @PostMapping("/user/add")
    public Result signup(HttpServletRequest request) {

        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            return new Result("fail", "duplicate phone number");
        }

        User user = new User(phoneNumber, password, username);
        userRepository.save(user);
        return new Result("success", "nothing", user);
    }

    @PostMapping("/user/deleteById")
    public Result deleteById(HttpServletRequest request) {

        String id = request.getParameter("id");

        if (!userRepository.existsById(id)) {
            return new Result("fail", "user not exist");
        }
        userRepository.deleteById(id);

        return new Result("success");
    }


    @PostMapping("/user/update")
    public Result update(HttpServletRequest request) {

        int posts = Integer.parseInt(request.getParameter("posts"));
        int following = Integer.parseInt(request.getParameter("following"));
        String userId = request.getParameter("userId");

        userRepository.setUserInfoById(posts, following, userId);

        return new Result("success", "nothing");
    }


}
