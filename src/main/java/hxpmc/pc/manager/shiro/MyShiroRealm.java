package hxpmc.pc.manager.shiro;

import hxpmc.pc.manager.pojo.User;
import hxpmc.pc.manager.service.Impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
        System.out.println("demo");
        return new SimpleAuthenticationInfo(loginuser, loginuser.getPassword(), ByteSource.Util.bytes(loginuser.getCredentials()),realmName);
    }
    }

