package com.nmid.ampm.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nmid.ampm.entity.Attachment;
import com.nmid.ampm.entity.DTO.MyList;
import com.nmid.ampm.mapper.AttachmentMapper;
import com.nmid.ampm.service.IAttachmentService;
import com.nmid.ampm.utils.ListConvertor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-25
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {

    @Override
    public boolean attachmentExits(String name, String times){
        Attachment one = this.getOne(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getName, name).eq(Attachment::getTimes, times));
        if (one != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MyList<Attachment> getAttachmentByName(String name) {
        List<Attachment> attachments = this.getBaseMapper().selectList(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getName, name));
        return ListConvertor.listConvertor(attachments);
    }

    @Override
    public MyList<Attachment> getAttachmentByTimes(String times) {
        List<Attachment> attachments = this.getBaseMapper().selectList(Wrappers.<Attachment>lambdaQuery().eq(Attachment::getTimes,times));
        return ListConvertor.listConvertor(attachments);
    }


}
