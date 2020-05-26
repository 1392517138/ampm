package com.nmid.ampm.result;

/**
 * 公共的返回码
 * 返回码code：
 * 成功：10000
 * 失败：10001
 * 未登录：10002
 * 未授权：10003
 * 抛出异常：99999
 */
public enum ResultCode {

    SUCCESS(true, 10000, "成功提交！"),
    //---系统错误返回码-----
    FAIL(false, 10001, "操作失败"),
    FILENAMEERROR(false,20000,"文件名命名错误"),
    SUCCESSMODIFY(true, 30000, "成功修改！"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");


    //---企业操作返回码  3xxxx----
    //---权限操作返回码----
    //---其他操作返回码----


    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
