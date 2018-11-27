package hxpmc.pc.manager.shiro;

import hxpmc.pc.manager.dao.roleDao;
import hxpmc.pc.manager.pojo.Role;
import hxpmc.pc.manager.pojo.User;
import hxpmc.pc.manager.service.Impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;
    @Autowired
        roleDao roleDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始验证");
      User user = (User) principalCollection.getPrimaryPrincipal();
      Role role = roleDao.findRole(user.getRoleId());

      SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
      info.addRole(role.getRole());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String  username=authenticationToken.getPrincipal().toString();//获取当前用户
        User loginuser = userService.findOne(username);
        Session session = SecurityUtils.getSubject().getSession();
        String realmName = this.getName();
        if(loginuser==null)
        {throw new UnknownAccountException();
        }
        System.out.println(username);
        System.out.println("Host:"+session.getHost());
        return new SimpleAuthenticationInfo(loginuser, loginuser.getPassword(), ByteSource.Util.bytes(loginuser.getCredentials()),realmName);
    }
    }

