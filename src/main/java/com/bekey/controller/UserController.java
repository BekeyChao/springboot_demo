package com.bekey.controller;

import com.bekey.domain.RestResult;
import com.bekey.domain.SysUser;
import com.bekey.service.SysUserService;
import com.bekey.utils.ResultGenerator;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;


/**
 * 用户控制器
 * Created by bekey on 2017/12/9.
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final SysUserService userService;

    private final ResultGenerator generator;

    @Autowired
    public UserController(SysUserService userService, ResultGenerator generator) {
        this.userService = userService;
        this.generator = generator;
    }

    @RequestMapping("/nameExists")
    public RestResult nameExists(@NotNull(message = "用户名不能为空") String name) {
        return generator.genSuccessResult(userService.nameExists(name));
    }

    @RequestMapping(value = "/reg")
    public RestResult reg(@Valid SysUser user, BindingResult result) {
        return generator.genSuccessResult("用户注册成功",userService.save(user));
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestResult login(HttpServletRequest request,  String name, String password, HttpSession session) {
        SysUser user = userService.checkLogin(name, password);
        if(user != null) {
            session.setAttribute("user",user);
            return generator.genSuccessResult("登陆成功",user);
        }
        return generator.genFailResult("用户名/密码错误");
    }
    /**
     * 为参数验证添加异常处理器
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RestResult handleConstraintViolationException(ConstraintViolationException cve) {
        String errorMessage = cve.getConstraintViolations().iterator().next().getMessage();
        return generator.genFailResult(errorMessage);
    }

    /**
     * 主键/唯一约束违反异常
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public RestResult handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return generator.genFailResult("违反主键/唯一约束条件");
    }
}
