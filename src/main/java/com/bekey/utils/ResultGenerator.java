package com.bekey.utils;

import com.bekey.domain.RestResult;
import com.bekey.domain.ResultCode;
import org.springframework.stereotype.Component;

/**
 * 接口信息生成工具
 * Created by bekey on 2017/12/10.
 */
@Component
public class ResultGenerator {

    private static final String SUCCESS = "success";

    public  RestResult genSuccessResult() {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(SUCCESS);
    }

    public  RestResult genSuccessResult(Object data) {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(SUCCESS)
                .setData(data);
    }

    public  RestResult genSuccessResult(String message,Object data) {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }

    public  RestResult genFailResult(String message) {
        return new RestResult()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public RestResult genFailResult(String message, Object data) {
        return new RestResult()
                .setCode(ResultCode.FAIL)
                .setMessage(message)
                .setData(data);
    }

    public RestResult genFreeResult(ResultCode code, String message, Object data) {
        return new RestResult()
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }
}
