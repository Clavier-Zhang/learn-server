package cloud.controllers;


import cloud.entities.Result;
import cloud.entities.User;
import cloud.repositories.FollowerRepository;
import cloud.repositories.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "User", description = "User operations")
public class UserController extends BaseController{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowerRepository followerRepository;


    @GetMapping("/user/all")
    public Iterable<User> all(HttpServletRequest request) {
        return userRepository.findAll();
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

    @PostMapping("/user/del")
    public Result del(HttpServletRequest request) {

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


    @PostMapping("/user/login")
    public Result login(HttpServletRequest request) {

        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        User user = userRepository.findByPhoneNumber(phoneNumber);

        if (user == null) {
            return new Result("fail", "phone number not exist");
        }


        if (!user.getPassword().equals(password)) {
            return new Result("fail", user.getPassword());
        }

        return new Result("success", "nothing", user);
    }

    @GetMapping("/user/logout")
    public String Logout(@RequestParam(value="name", defaultValue="World") String name) {

        return "111111111";
    }
}
