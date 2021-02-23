package com.xxx.springboot;

import com.xxx.springboot.exceptions.ParamsException;
import com.xxx.springboot.model.ResultInfo;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 22:47
 * @Description:com.xxx.springboot
 * @version:v1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler { //全局异常处理类

    @ExceptionHandler(value = ParamsException.class)
    @ResponseBody
    public ResultInfo dealParamsException(ParamsException pe) {  //处理参数异常的方法
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(pe.getCode());
        resultInfo.setMsg(pe.getMsg());
        return resultInfo;
    }

    //参数绑定的异常处理
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultInfo dealBindException(BindException be) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(500);
        resultInfo.setMsg(be.getBindingResult().getFieldError().getDefaultMessage());
        return resultInfo;
    }

    @ExceptionHandler
    @ResponseBody
    public ResultInfo dealException(Exception ex) {   //如果都没走,就走这个方法
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMsg("操作失败");
      /*  if (ex instanceof ParamsException) {  //判断异常类型
            ParamsException pe = (ParamsException) ex;
            resultInfo.setMsg(pe.getMsg());
            resultInfo.setCode(pe.getCode());
        }*/

        return resultInfo;

    }


}
