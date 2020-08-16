package com.nmid.ampm.controller;

import com.nmid.ampm.exception.CommonException;
import com.nmid.ampm.result.Result;
import com.nmid.ampm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Aaron
 * @description
 * @date 2020/5/24 11:43 PM
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService cilentService;

    @PostMapping("/uploadsFile")
    public Result uploadsFile(MultipartFile multipartFile) throws CommonException {
        return cilentService.uploadsFile(multipartFile);
    }

    @PostMapping("/getTiems")
    public Result getTiems() {
        return cilentService.getTiems();
    }


}
