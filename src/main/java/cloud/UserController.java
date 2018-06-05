package cloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import cloud.User;

@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/list")
    public Iterable<User> List(HttpServletRequest request) {
        return userRepository.findAll();
    }


    @PostMapping("/signup")
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


    @RequestMapping("/login")
    public Result Login(HttpServletRequest request) {

        return new Result("success", "nothing");
    }

    @RequestMapping("/loogut")
    public String Logout(@RequestParam(value="name", defaultValue="World") String name) {
        return "111111111";
    }
}
