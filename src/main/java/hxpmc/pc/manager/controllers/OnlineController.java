package hxpmc.pc.manager.controllers;

import hxpmc.pc.manager.pojo.UserOnline;
import hxpmc.pc.manager.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("onlineManager")
public class OnlineController {
    @Autowired
    SessionService sessionService;
    @RequestMapping("/manager")
    public String  onlineManager(Model model){
        List<UserOnline> list = sessionService.list();
        model.addAttribute("session",list);
        return "onlineManager";
    }
    @ResponseBody
    @RequestMapping("forceLoginOut")
    public boolean force(String sessionId){
        sessionService.forceLogout(sessionId);
        return true;
    }
}
