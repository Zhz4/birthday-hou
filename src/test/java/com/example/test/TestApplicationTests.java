package com.example.test;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        //地域节点(Endpoint)的配置
        String endpoint = "oss-cn-shenzhen.aliyuncs.com";

        //RAM子用户的key值
        String accessKeyId = "LTAI5t6r23uBpPNcsUp1Vzt5";
        String accessKeySecret = "Y6LSQA0cRFf7jzkT6dsDijOeB1yTYZ";

        //声明OSS云存储的Bucket名称。
        String bucketName = "my-photos-ts";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();

    }

}
