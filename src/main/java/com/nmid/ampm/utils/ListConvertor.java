package com.nmid.ampm.utils;

import com.nmid.ampm.entity.Attachment;
import com.nmid.ampm.entity.DTO.MyList;

import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/5/25 10:51 PM
 */
public class ListConvertor {
    public static MyList<Attachment> listConvertor(List<Attachment> list) {
        MyList<Attachment> attachments = new MyList<>();
        for (Attachment attachment : list) {
            attachments.add(attachment);
        }
        return attachments;
    }
}
