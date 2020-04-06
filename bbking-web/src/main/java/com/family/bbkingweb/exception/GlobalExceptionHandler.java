package com.family.bbkingweb.exception;

import com.family.bbkingbase.common.CodeMsg;
import com.family.bbkingbase.common.Result;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Result handlerException(HttpServletRequest request,
//                                   Exception e){
//        CodeMsg codeMsg = new CodeMsg(500,e.getMessage());
//        return new Result(codeMsg,request.getRequestURI());
//    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Result defaultExceptionHandler(HttpServletRequest req,Exception e){
        CodeMsg codeMsg = new CodeMsg(500,"对不起，你没有访问权限！");
        return new Result(codeMsg,null);
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public Result throwAuthenticationException(HttpServletRequest req,Exception e){
        CodeMsg codeMsg = new CodeMsg(500,"账号验证异常，请重新登录！");
        return new Result(codeMsg,null);
    }

}
