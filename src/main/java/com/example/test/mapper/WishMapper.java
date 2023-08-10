package com.example.test.mapper;

import com.example.test.bean.wishBean;

import java.util.List;

public interface WishMapper {

    List<wishBean> getWish();

    int addWish(String id,String content,String ip,String time,String address);
}
