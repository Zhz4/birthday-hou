package com.example.test.service;

import com.example.test.requestJson.Format;

public interface DanmuSerive {

    /**
     * 添加弹幕
     * @param content 弹幕内容
     * @param setup 弹幕设置
     * @param ip ip地址
     * @return Format
     */
    Format add(String content, String setup, String ip);

    /**
     * 获取所有弹幕
     * @return 弹幕内容
     */
    Format get();
    /**
     * 获取弹幕数量
     * @return 弹幕数量
     */
    Format getDanmuCount();
}
