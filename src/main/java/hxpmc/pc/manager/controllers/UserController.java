package hxpmc.pc.manager.controllers;

import hxpmc.pc.manager.pojo.User;
import hxpmc.pc.manager.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("regist")
    public String registy(User user){
        userService.addUser(user);
        return "sss";
    }
}
