package com.example.test.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
public class getAddress {
    public static String GetAddress(String ip){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://whois.pconline.com.cn/ipJson.jsp?ip=" + ip + "&json=true");

        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            // 使用Jackson库解析JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            // 获取"addr"对应的值
            String addr = jsonNode.get("addr").asText().split(" ")[0];
            return addr;
            // 在这里处理响应内容
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String ip = "113.88.159.253";
        String res = GetAddress(ip);
        System.out.println(res);
    }
}
