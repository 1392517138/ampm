package com.nmid.ampm.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nmid.ampm.entity.Pmzhaoxin;
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
public interface IPmzhaoxinService extends IService<Pmzhaoxin> {
    /**
     * @Description: 通过姓名获得邮箱
     * @Param
     * @Date: 4:19 PM 2020/5/26
     */
    String getEmailByName(String name);

    /**
     * @Description: 获得所有培训生的姓名
     * @Param
     * @Date: 4:19 PM 2020/5/26
     */
    List<String> getNames();

}
