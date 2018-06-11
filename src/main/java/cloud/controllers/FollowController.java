package cloud.controllers;

import cloud.entities.Result;
import cloud.repositories.FollowerRepository;
import cloud.repositories.UserRepository;
import cloud.entities.Follow;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "Follow", description = "Follow operations")
public class FollowController extends BaseController{

    @Autowired
    private FollowerRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/follow/all")
    public Iterable<Follow> list(HttpServletRequest request) {
        return followRepository.findAll();
    }

    @GetMapping("/follow/delAll")
    public Result delAll(HttpServletRequest request) {
        followRepository.deleteAll();
        return new Result("success");
    }

    @PostMapping("/follow/add")
    public Result add(HttpServletRequest request) {
        String user = request.getParameter("user");
        String following = request.getParameter("following");

        if (user.equals(following)) {
            return new Result("fail", "can not follow self");
        }

        Follow follow = new Follow(user, following);
        followRepository.save(follow);

        return new Result("success", "nothing", follow);
    }

    @PostMapping("/follow/del")
    public Iterable<Follow> del(HttpServletRequest request) {
        return followRepository.findAll();
    }

    @PostMapping("/follow/getAllFollowers")
    public Iterable<Follow> getAllFollowers(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        return followRepository.findAllByUserId(userId);
    }

    @PostMapping("/follow/getAllFollowing")
    public Iterable<Follow> getAllFollowing(HttpServletRequest request) {
        String followId = request.getParameter("followId");
        return followRepository.findAllByFollowId(followId);
    }


}
