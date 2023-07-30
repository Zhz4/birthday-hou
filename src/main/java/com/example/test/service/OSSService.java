package com.example.test.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class OSSService {

    @Autowired
    private OSS ossClient;

    @Value("${oss.bucketName}")
    private String bucketName;

    // 上传文件
    public String uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            ossClient.putObject(bucketName, fileName, file.getInputStream());
            return fileName;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // 下载文件
    public InputStream downloadFile(String fileName) {
        try {
            OSSObject object = ossClient.getObject(bucketName, fileName);
            return object.getObjectContent();
        } catch (OSSException e) {
            // 处理下载失败的逻辑
        }
        return null;
    }
}