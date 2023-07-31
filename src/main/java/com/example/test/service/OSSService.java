package com.example.test.service;

import com.example.test.requestJson.Format;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public interface OSSService {
    // 上传文件
    Format uploadFile(MultipartFile file);
}