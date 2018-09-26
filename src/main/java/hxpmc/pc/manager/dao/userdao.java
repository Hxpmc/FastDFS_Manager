package hxpmc.pc.manager.dao;

import hxpmc.pc.manager.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface userdao {
    public User findOne(String username);
    public int  addUser(User  user);
}
