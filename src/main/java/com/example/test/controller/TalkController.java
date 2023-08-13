package com.example.test.controller;

import com.example.test.bean.talkBean;
import com.example.test.enmu.Request;
import com.example.test.mapper.TalkMapper;
import com.example.test.requestJson.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Talk")
public class TalkController {
    @Autowired
    private TalkMapper talkMapper;

    @RequestMapping("/get")
    public Format get(@RequestParam("id") String id) {
        talkBean result = talkMapper.getTalkById(id);
        Format format = new Format();
        Request request = Request.SUCCESS;
        format.setCode(request.getCode());
        format.setMsg("success");
        format.setData(result);
        return format;
    }
}
