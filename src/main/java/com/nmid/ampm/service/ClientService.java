package com.nmid.ampm.service;

import com.nmid.ampm.exception.CommonException;
import com.nmid.ampm.result.Result;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Aaron
 * @description
 * @date 2020/5/24 11:45 PM
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface ClientService {

    /**
     * 上传文件
     * @param multipartFile
     * @param times
     */
    Result uploadsFile(MultipartFile multipartFile, String times) throws CommonException;
}
