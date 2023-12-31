package com.example.test.controller;

import com.example.test.requestJson.Format;
import com.example.test.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping("/getAllImage")
    public Format getAllImage() {
        return imageService.getAllImage();
    }
}
