package com.example.test.controller;

import com.example.test.requestJson.Format;
import com.example.test.service.WishSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/wish")
public class WishController {
    @Autowired
    private WishSerive wishSerive;
    @GetMapping("/getWish")
    public Format getWish(){
        return wishSerive.getWish();
    }
    @PostMapping("/addWish")
    public Format addWish(@RequestParam("content") String content, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        return wishSerive.addWish(content,ip);
    }
}
