package cloud.controllers;

import cloud.entities.Result;
import cloud.repositories.FollowRepository;
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
    private FollowRepository followRepository;

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
        String userId = request.getParameter("userId");
        String followId = request.getParameter("followId");

        if (userId.equals(followId)) {
            return new Result("fail", "can not follow self");
        }

        Follow follow = new Follow(userId, followId);
        followRepository.save(follow);

        return new Result("success", "nothing", follow);
    }

    @PostMapping("/follow/deleteByUserId")
    public Result delByUserId(HttpServletRequest request) {

        String userId = request.getParameter("userId");

        followRepository.deleteByUserId(userId);

        return new Result("success");

    }

    @PostMapping("/follow/delByFollowId")
    public Result delByFollowId(HttpServletRequest request) {

        String followId = request.getParameter("followId");

        followRepository.deleteByFollowId(followId);

        return new Result("success");

    }

    @PostMapping("/follow/deleteByUserIdAndFollowId")
    public Result delByUserIdAndFollowId(HttpServletRequest request) {

        String userId = request.getParameter("userId");
        String followId = request.getParameter("followId");

        followRepository.deleteByUserIdAndFollowId(userId, followId);

        return new Result("success");

    }

    @PostMapping("/follow/getAllFollowers")
    public Iterable<Follow> getAllFollowers(HttpServletRequest request) {

        String userId = request.getParameter("userId");

        return followRepository.findAllByUserId(userId);

    }

    @PostMapping("/follow/getAllFollowings")
    public Iterable<Follow> getAllFollowing(HttpServletRequest request) {

        String followId = request.getParameter("followId");

        return followRepository.findAllByFollowId(followId);

    }


}
