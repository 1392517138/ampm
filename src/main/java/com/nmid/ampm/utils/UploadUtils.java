package com.nmid.ampm.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

/**
 * @author Aaron
 * @description
 * @date 2020/4/14 9:52 AM
 */

public class UploadUtils {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static String endpoint = "http://oss-accelerate.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static String accessKeyId = "LTAI4FuvdDyyX4QxsUtpkeSv";
    private static String accessKeySecret = "xdOZ69pe2jB9yj1IEUwLvZrtjV4r3x";
    private static String bucketName = "smart-house-img";
    private static String SUFFER_URL = "https://smart-house-img.oss-accelerate.aliyuncs.com/";

    public static String uploadImage(MultipartFile file,String times) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String filename = "shujuku/nmid/" + times + "/" + file.getOriginalFilename();
//        System.out.println(filename);
        //文件地址
        System.out.println(filename);
        System.out.println(times);
        String url = null;
        try {
            ossClient.putObject(bucketName, filename, new ByteArrayInputStream(file.getBytes()));
            url = SUFFER_URL + filename;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        System.out.println(url);
        return url;
    }
}
