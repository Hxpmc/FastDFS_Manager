package hxpmc.pc.manager.service;

import hxpmc.pc.manager.pojo.User;

public interface UserService {
    public User findOne(String username);
    public int addUser(User user);
}
