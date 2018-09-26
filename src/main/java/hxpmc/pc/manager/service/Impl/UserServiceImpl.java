package hxpmc.pc.manager.service.Impl;

import hxpmc.pc.manager.dao.userdao;
import hxpmc.pc.manager.pojo.User;
import hxpmc.pc.manager.service.PasswordHelper;
import hxpmc.pc.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    userdao userdao;
    @Autowired
    PasswordHelper passwordHelper;

    public User findOne(String username) {
        return userdao.findOne(username);
    }

    @Override
    public int addUser(User user) {
        passwordHelper.encryptPassword(user);
    int i = userdao.addUser(user);
      return i;
    }
}
