package com.example.test.controller;

import com.example.test.requestJson.Format;
import com.example.test.service.DanmuSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/danmu")
public class danmuController {
    @Autowired
    private DanmuSerive danmuSerive;
    @PostMapping("/add")
    public Format add(@RequestParam("content") String content, @RequestParam("setup") String setup, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        return danmuSerive.add(content,setup,ip);
    }

    @GetMapping("/get")
    public Format get(){
        return danmuSerive.get();
    }

    @GetMapping("/getDanmuCount")
    public Format getDanmuCount(){
        return danmuSerive.getDanmuCount();
    }

}
