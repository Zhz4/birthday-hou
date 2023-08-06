package com.example.test.controller;

import com.example.test.requestJson.Format;
import com.example.test.service.UploadSerive;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping(value = "/filelocal",produces = "application/json;charset=UTF-8")
public class FilelocalController {

    //将Service注入Web层
    @Autowired
    private UploadSerive uploadSerive;
    @PostMapping("/upload")
    public Format upload(@RequestParam("imgFile") MultipartFile[] files) throws Exception {
        return uploadSerive.uploadFile(files);
    }
}
