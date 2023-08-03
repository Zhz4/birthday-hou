package com.example.test.serviceImpl;

import com.example.test.bean.danmuBean;
import com.example.test.enmu.Request;
import com.example.test.mapper.DanmuMapper;
import com.example.test.requestJson.Format;
import com.example.test.service.DanmuSerive;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DanmuSeriveImpl implements DanmuSerive {
    @Autowired
    private DanmuMapper danmuMapper;

    @Override
    public Format add(String content, String setup, String ip) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        String time = String.valueOf(System.currentTimeMillis());
        int row = danmuMapper.add(id, content, ip, setup, time);
        return getFormat(row);
    }

    @Override
    public Format get() {
        List<danmuBean> res = danmuMapper.get();
        Request request = Request.SUCCESS;
        Format format = new Format();
        format.setMsg("success");
        format.setData(res);
        format.setCode(request.getCode());
        return format;
    }

    @NotNull
    static Format getFormat(int row) {
        Format format = new Format();
        if (row > 0) {
            Request request = Request.SUCCESS;
            format.setCode(request.getCode());
            format.setMsg("success");
        } else {
            Request request = Request.ERROR;
            format.setCode(request.getCode());
            format.setMsg("fail");
        }
        return format;
    }
}
