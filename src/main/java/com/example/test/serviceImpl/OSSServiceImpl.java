package com.example.test.serviceImpl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.example.test.enmu.Request;
import com.example.test.requestJson.Format;
import com.example.test.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.example.test.common.UniqueHexCodeGenerator.generateUniqueHexCode;

@Service
public class OSSServiceImpl implements OSSService {
    @Autowired
    private OSS ossClient;

    @Value("${oss.bucketName}")
    private String bucketName;

    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") || FilenameExtension.equalsIgnoreCase(".jpg") || FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") || FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") || FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpg";
    }

    // 上传文件
    @Override
    public Format uploadFile(MultipartFile file) {
        Format format = new Format();
        try {
            String fileName = file.getOriginalFilename();
            String uniqueHexCode = generateUniqueHexCode();
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);

            // 匹配文件格式
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            if (suffix.equals(".jpg") || suffix.equals(".png") || suffix.equals(".jpeg")) {
                PutObjectResult putObjectRequest = ossClient.putObject(bucketName, "image/" + uniqueHexCode + suffix, file.getInputStream(), objectMetadata);
                format.setData(putObjectRequest);
            }else if (suffix.equals(".mp4") || suffix.equals(".avi") || suffix.equals(".mov")) {
                PutObjectResult putObjectRequest = ossClient.putObject(bucketName, "video/" + uniqueHexCode + suffix, file.getInputStream(), objectMetadata);
                format.setData(putObjectRequest);
            }
            Request request = Request.SUCCESS;
            format.setCode(request.getCode());
            format.setMsg("上传成功");
            return format;
        } catch (IOException e) {
            // 处理上传失败的逻辑
            Request request = Request.ERROR;
            format.setCode(request.getCode());
            format.setMsg("上传失败");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
