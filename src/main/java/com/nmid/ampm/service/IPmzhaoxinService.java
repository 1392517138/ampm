package com.nmid.ampm.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nmid.ampm.entity.Pmzhaoxin;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-25
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IPmzhaoxinService extends IService<Pmzhaoxin> {
    String getEmailByName(String name);

}
