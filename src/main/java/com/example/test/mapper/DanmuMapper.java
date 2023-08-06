package com.example.test.mapper;

import com.example.test.bean.danmuBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DanmuMapper {
    int add(String id, String content, String ip, String setup, String time,String address);
    List<danmuBean> get();
}
