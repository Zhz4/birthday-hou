package com.example.test.mapper;

import com.example.test.bean.imageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ImageMapper {
    List<imageBean> getAllImage();
}
