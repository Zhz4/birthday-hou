package com.example.test.service;

import com.example.test.requestJson.Format;
import org.springframework.web.multipart.MultipartFile;


public interface UploadSerive {
    // 上传文件
    Format uploadFile(MultipartFile[] files) throws Exception;
}
