package cloud.controllers;

import cloud.entities.Result;
import cloud.services.ImageService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@RestController
public class ImageController extends BaseController {

    @Resource
    private ImageService imageService;

    @PostMapping(value="/multipleSave")
    public Result multipleSave(@RequestParam("file") MultipartFile[] files){

        if (files != null && files.length >0) {
            saveImages(files);
            return new Result("success");

        } else {
            return new Result("fail");
        }

    }



    @GetMapping(value = { "/image/{filename:.+}" },
            produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE })
    public byte[] getImg(@PathVariable String filename) {

        Path path = Paths.get("/Users/mac/Desktop/java-spring-rest-api/upload/" + filename);
        byte[] data = null;

        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return data;
    }
}

