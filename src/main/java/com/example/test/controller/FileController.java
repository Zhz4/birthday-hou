package com.example.test.controller;

import com.example.test.requestJson.Format;
import com.example.test.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private OSSService ossService;

    @PostMapping("/upload")
    public Format uploadFile(@RequestParam("file") MultipartFile file) {
        return ossService.uploadFile(file);
    }
}
