package cloud.controllers;


import cloud.entities.Post;
import cloud.entities.Result;
import cloud.repositories.PostRepository;
import cloud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ConfessWallController extends BaseController{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/confessPost/list")
    public Iterable<Post> all(HttpServletRequest request) {
        return postRepository.findAll();
    }

    @GetMapping("/confessPost/deleteAll")
    public Result deleteAll(HttpServletRequest request) {
        postRepository.deleteAll();
        return new Result("success", "delete all");
    }

    @PostMapping("/confessPost/add")
    public Result add(HttpServletRequest request) {

        String authorId = request.getParameter("authorId");
        String content = request.getParameter("content");


        Post post = new Post();
        post.setAuthorId(authorId);
        post.setComments(0);
        post.setAnonymous(false);
        post.setLikes(0);
        post.setType("confess");
        post.setContent(content);
        postRepository.save(post);

        return new Result("success");
    }

}
