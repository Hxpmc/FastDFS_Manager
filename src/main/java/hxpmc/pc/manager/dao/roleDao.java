package hxpmc.pc.manager.dao;

import hxpmc.pc.manager.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface roleDao {
    public Role  findRole(int id);
    public void  addRole(Role role);

}
