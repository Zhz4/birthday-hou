package com.example.test.serviceImpl;

import com.example.test.bean.imageBean;
import com.example.test.enmu.Request;
import com.example.test.mapper.ImageMapper;
import com.example.test.requestJson.Format;
import com.example.test.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public Format getAllImage() {
        List<imageBean> allImage = imageMapper.getAllImage();
        Request request = Request.SUCCESS;
        Format format = new Format();
        format.setData(allImage);
        format.setCode(request.getCode());
        format.setMsg("success");
        return format;
    }
}
