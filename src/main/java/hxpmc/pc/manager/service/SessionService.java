package hxpmc.pc.manager.service;

import hxpmc.pc.manager.pojo.UserOnline;

import java.util.List;

public interface SessionService {
    List<UserOnline> list();
    boolean forceLogout(String sessionId);
}
