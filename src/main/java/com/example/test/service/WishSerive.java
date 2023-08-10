package com.example.test.service;

import com.example.test.requestJson.Format;

public interface WishSerive {

    /**
     * 获取愿望
     * @return 愿望
     */
    Format getWish();

    /**
     * 添加愿望
     * @return 是否成功
     */
    Format addWish(String content,String ip);
}
