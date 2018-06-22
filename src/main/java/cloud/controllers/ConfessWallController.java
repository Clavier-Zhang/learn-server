package cloud.controllers;


import cloud.entities.Post;
import cloud.entities.Result;
import cloud.repositories.PostRepository;
import cloud.repositories.UserRepository;
import cloud.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class ConfessWallController extends BaseController{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Resource
    private ImageService imageService;



    @GetMapping("/confessPost/list")
    public Iterable<Post> all() {
        return postRepository.findAll();
    }

    @GetMapping("/confessPost/deleteAll")
    public Result deleteAll(HttpServletRequest request) {
        postRepository.deleteAll();
        return new Result("success", "delete all");
    }




    @PostMapping("/confessPost/add")
    public Result add(HttpServletRequest request, @RequestParam("image") MultipartFile[] images) {

        String authorId = request.getParameter("authorId");
        String content = request.getParameter("content");


        Post post = new Post();
        post.setAuthorId(authorId);
        post.setComments(0);
        post.setAnonymous(false);
        post.setLikes(0);
        post.setType("confess");
        post.setContent(content);
        post.setDate(new Date());
        postRepository.save(post);

        Result result = imageService.saveImagesById(authorId, images);

        return new Result("success");
    }

    @PostMapping("confessPost/get")
    public Result getTenByDate(HttpServletRequest request) throws ParseException {

        String date = request.getParameter("date");

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String dateString = "2018-06-21T15:22:11.000+0000";
        Date dateObject = sdf.parse(dateString);



        System.out.println(new Date());

        Iterable<Post> posts = postRepository.findTop3ByDateBeforeOrderByDateDesc(dateObject);


        return new Result("success", "test", posts);
    }



}
