package com.nmid.ampm.utils;


import com.nmid.ampm.entity.Attachment;
import com.nmid.ampm.entity.DTO.MyList;
import com.nmid.ampm.entity.Pmzhaoxin;
import com.nmid.ampm.service.IAttachmentService;
import com.nmid.ampm.service.IPmzhaoxinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author piwenjing
 * @description
 * @date 2020/3/27 2:05 PM
 */
@Component
public class ShortMessageUtil {
    @Resource
    private JavaMailSenderImpl mailSender;
    @Autowired
    private IAttachmentService iAttachmentService;
    @Autowired
    private IPmzhaoxinService iPmzhaoxinService;

    @Value("${spring.mail.username}")
    private String from;
    @Value("${spring.mail.title}")
    private String title;
    @Value("${spring.mail.content}")
    private String content;

    private static String tail = "此致\n\n    祝好\n\nPM";
    private List<String> names;
    private String nonames = "";
    public void sendMail(String[] to,String name,byte b,String times) {
        String content = "";
        MyList<Attachment> attachmentByName = null;
        int i = 0;
        //b为0代表学生
        if (b == 0){
            attachmentByName = iAttachmentService.getAttachmentByName(name);
            content = "你所上传的所有附件如下：\n\n";
        } else {
            attachmentByName = iAttachmentService.getAttachmentByTimes(times);
            //获得姓名
            names = iPmzhaoxinService.getNames();
            //获得人数
            int num = names.size();
            nonames = names.toString();
            for (Attachment attachment : attachmentByName) {
                if (nonames.contains(attachment.getName())){
                    i++;
                }
                nonames = nonames.replace(attachment.getName(),"");
            }
            content = "学员作业内容如下：\n\n"+"共有 "+num+" 人，完成人数"+i+"人,未完成的为："+nonames+"\n\n";
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to[0]);
        message.setSubject(title);
        System.out.println(attachmentByName.toString());
        message.setText(name+", 你好！\n\n" + content+attachmentByName.toString()+"\n"+tail);
        mailSender.send(message);
    }
}
