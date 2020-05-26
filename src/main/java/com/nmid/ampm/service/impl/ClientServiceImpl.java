package com.nmid.ampm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nmid.ampm.entity.Attachment;
import com.nmid.ampm.exception.CommonException;
import com.nmid.ampm.result.Result;
import com.nmid.ampm.result.ResultCode;
import com.nmid.ampm.service.ClientService;
import com.nmid.ampm.service.IAttachmentService;
import com.nmid.ampm.service.IPmzhaoxinService;
import com.nmid.ampm.utils.ShortMessageUtil;
import com.nmid.ampm.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Aaron
 * @description
 * @date 2020/5/24 11:46 PM
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    IAttachmentService iattachmentService;
    @Autowired
    IPmzhaoxinService iPmzhaoxinService;
    @Autowired
    ShortMessageUtil shortMessageUtil;

    private static String regx = "^.+-.+$";
    boolean exits = false;
    @Override
    public Result uploadsFile(MultipartFile multipartFile, String times) throws CommonException {
        //1.判断文件是否为空
        if (multipartFile == null){
            return new Result(ResultCode.FAIL);
        }
        //2.判断是否符合命名规则。如：小明-第一次
        String fileName = multipartFile.getOriginalFilename();
        if (!Pattern.matches(regx,fileName)){
            return new Result(ResultCode.FILENAMEERROR);
        }
        String name = fileName.substring(0,fileName.indexOf("-"));
        Attachment attachment = new Attachment();
        //3.判断是否已经存在
        exits = iattachmentService.attachmentExits(name,times);
        System.out.println(exits);
        //4.生成对象
        attachment.setName(name);
        attachment.setFileName(fileName);
        attachment.setTimes(times);
        try {
            String url = UploadUtils.uploadImage(multipartFile,times);
            attachment.setFileUrl(url);
            //存在即更新
            if (exits){
                attachment.setUpdateTime(LocalDateTime.now());
                iattachmentService.update(attachment,Wrappers.<Attachment>lambdaQuery().eq(Attachment::getName,name).eq(Attachment::getTimes,times));
            } else {
                //否则插入
                iattachmentService.save(attachment);
            }
            //发送邮件反馈
            String email = iPmzhaoxinService.getEmailByName(name);
            sendEmail(email, name, (byte)0,times);
            //如果是修改
            if (exits){
                return new Result(ResultCode.SUCCESSMODIFY,url);
            }
            return new Result(ResultCode.SUCCESS,url);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new CommonException(ResultCode.SERVER_ERROR);
        }
    }

    //发送邮件，给新生
    private void sendEmail(String email,String name, byte b,String times) {
        //5.给该新生发邮件。
        shortMessageUtil.sendMail(new String[]{email},name,b,times);
    }
}
