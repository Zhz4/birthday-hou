package com.example.test.serviceImpl;

import com.example.test.bean.wishBean;
import com.example.test.enmu.Request;
import com.example.test.mapper.WishMapper;
import com.example.test.requestJson.Format;
import com.example.test.service.WishSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.test.util.getAddress.GetAddress;

@Service
public class WishSeriveImpl implements WishSerive {
    @Autowired
    private WishMapper wishMapper;

    @Override
    public Format getWish() {
        List<wishBean> res = wishMapper.getWish();
        Format format = new Format();
        format.setMsg("success");
        format.setData(res);
        Request request = Request.SUCCESS;
        format.setCode(request.getCode());
        return format;
    }

    @Override
    public Format addWish(String content,String ip) {
        String address = GetAddress(ip);
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        String time = String.valueOf(System.currentTimeMillis());
        int row = wishMapper.addWish(id,content,ip,time,address);
        Format format = new Format();
        if (row>0){
            format.setMsg("添加成功");
            Request request = Request.SUCCESS;
            format.setCode(request.getCode());
        }else {
            format.setMsg("添加失败");
            Request request = Request.ERROR;
            format.setCode(request.getCode());
        }
        return format;
    }
}
