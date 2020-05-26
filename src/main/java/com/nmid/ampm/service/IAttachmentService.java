package com.nmid.ampm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nmid.ampm.entity.Attachment;
import com.nmid.ampm.entity.DTO.MyList;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-25
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IAttachmentService extends IService<Attachment> {
    //通过文件名和第几次返回姓名
    boolean attachmentExits(String name, String times);

    //通过姓名查找所有附件
    MyList<Attachment> getAttachmentByName(String name);

    //通过次数查找所有附件
    MyList<Attachment> getAttachmentByTimes(String times);
}
