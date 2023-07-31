package com.example.test.serviceImpl;

import com.example.test.enmu.Request;
import com.example.test.mapper.UploadImageMapper;
import com.example.test.requestJson.Format;
import com.example.test.service.UploadSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@Service
public class uploadSeriveImpl implements UploadSerive {
    @Autowired
    private UploadImageMapper uploadImageMapper;

    private String generateNewFilename(String originalFilename) {
        // 在这里编写生成新文件名的逻辑，可以使用时间戳、随机数等来生成唯一的新文件名
        // 示例：在原文件名前加上时间戳
        long timestamp = System.currentTimeMillis();
        return timestamp + "_" + originalFilename;
    }
    @Override
    public Format uploadFile(MultipartFile[] files)  {
        try {
            File imageDir = new File("uploadFile/image");
            if (!imageDir.exists()) {
                imageDir.mkdirs();
            }

            File videoDir = new File("uploadFile/video");
            if (!videoDir.exists()) {
                videoDir.mkdirs();
            }
            int fileLength = files.length;
            int fileSuccess = 0;
            for (MultipartFile file : files) {
                String originalFilename = file.getOriginalFilename();
                String newFilename = generateNewFilename(originalFilename);
                // 匹配文件格式
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                if (suffix.equals(".jpg") || suffix.equals(".png") || suffix.equals(".jpeg")) {
                    file.transferTo(new File(imageDir.getAbsolutePath() + File.separator + newFilename));
                    fileSuccess += 1;
                    uploadImageMapper.addimage(imageDir.getAbsolutePath() + File.separator + newFilename);
                }else if (suffix.equals(".mp4") || suffix.equals(".avi") || suffix.equals(".mov")) {
                    file.transferTo(new File(videoDir.getAbsolutePath() + File.separator + newFilename));
                    fileSuccess += 1;
                    uploadImageMapper.addimage(imageDir.getAbsolutePath() + File.separator + newFilename);
                }
            }
            Request code = Request.SUCCESS;
            return new Format(code.getCode(), "成功:"+fileSuccess+"失败:"+ (fileLength-fileSuccess), "上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            Request code = Request.ERROR;
            return new Format(code.getCode(), null, "上传失败");
        }
    }
}