package cloud.controllers;

import cloud.entities.Result;
import cloud.entities.User;
import cloud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(("/api"))
public class BaseController {

    @Autowired
    private UserRepository userRepository;



}
