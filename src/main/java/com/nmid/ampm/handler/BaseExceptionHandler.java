package com.nmid.ampm.handler;



import com.nmid.ampm.exception.CommonException;
import com.nmid.ampm.result.Result;
import com.nmid.ampm.result.ResultCode;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的公共异常处理器
 * 1.声明异常处理器
 * 2.对异常统一处理
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        if (e.getClass() == CommonException.class) {
            //类型转型
            CommonException ce = (CommonException) e;
            Result result = new Result(ce.getResultCode());
            return result;
        } else if(e.getClass() == MaxUploadSizeExceededException.class || e.getClass() == FileUploadBase.SizeLimitExceededException.class ){
            System.out.println("为进来了12312321");
            Result result =  new Result(ResultCode.SIZEEXCEEDEDERROR);
            return result;
        } else {
            Result result = new Result(ResultCode.SERVER_ERROR);
            return result;
        }

    }


}
