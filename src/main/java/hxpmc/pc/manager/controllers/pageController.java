package hxpmc.pc.manager.controllers;

import hxpmc.pc.manager.pojo.pic;
import hxpmc.pc.manager.service.PicService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class pageController {
    @Autowired
    PicService picService;
    @PostMapping("login")
    public String login(HttpServletRequest req, Model model){
        String exception = (String) req.getAttribute("shiroLoginFailure");
        Subject subject = SecurityUtils.getSubject();

        System.out.println(subject);
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        return "login";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("loginout")
    public String loginout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
    @RequestMapping("index")
    public  String index(){
        return "index";
    }

@RequestMapping("register")
public String regist(){
    return "register";
}

    @RequestMapping("item")
    public String item(){
        return "item";
    }
    @RequestMapping("filemanager")
    public String filemanager(Model model){
        List<pic> list =picService.findAll();
        model.addAttribute("pic",list);
        return "filemanager";
    }
}