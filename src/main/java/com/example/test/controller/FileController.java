package com.example.test.controller;

import com.example.test.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        return ossService.uploadFile(file);
    }
    @GetMapping("/download/{fileName}")
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        InputStream inputStream = ossService.downloadFile(fileName);
        if (inputStream !=
                null) {
            try {
                StreamUtils.copy(inputStream, response.getOutputStream());
                response.setContentType("application/octet-stream");
                response.flushBuffer();
            } catch (IOException e) {
                // 处理下载失败的逻辑
            }
        } else {
            // 处理文件不存在的逻辑
        }
    }
}
