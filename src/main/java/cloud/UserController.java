package cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public Iterable<User> List(HttpServletRequest request) {
        return userRepository.findAll();
    }

    @GetMapping("/add")
    public String add(HttpServletRequest request) {
        User n = new User();
        n.setName(request.getParameter("name"));
        n.setEmail(request.getParameter("email"));
        userRepository.save(n);
        return "Saved";
    }

    @RequestMapping("/login")
    public Result Login(HttpServletRequest request) {

        User user = new User();
        user.setName(request.getParameter("name"));
        Result result = new Result();
        result.setStatus("success");
        result.setUser(user);
        return result;
    }

    @RequestMapping("/loogut")
    public String Logout(@RequestParam(value="name", defaultValue="World") String name) {
        return "111111111";
    }
}
