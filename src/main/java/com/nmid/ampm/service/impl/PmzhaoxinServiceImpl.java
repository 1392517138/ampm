package com.nmid.ampm.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nmid.ampm.entity.Pmzhaoxin;
import com.nmid.ampm.mapper.PmzhaoxinMapper;
import com.nmid.ampm.service.IPmzhaoxinService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-25
 */
@Service
public class PmzhaoxinServiceImpl extends ServiceImpl<PmzhaoxinMapper, Pmzhaoxin> implements IPmzhaoxinService {


    @Override
    public String getEmailByName(String name) {
        Pmzhaoxin one = getOne(Wrappers.<Pmzhaoxin>lambdaQuery().eq(Pmzhaoxin::getName, name));
        return one.getEmail();
    }
}
