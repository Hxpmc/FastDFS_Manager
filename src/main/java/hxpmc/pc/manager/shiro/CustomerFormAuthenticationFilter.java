package hxpmc.pc.manager.shiro;

import hxpmc.pc.manager.pojo.User;
import hxpmc.pc.manager.service.UserService;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
@Component
public class CustomerFormAuthenticationFilter extends FormAuthenticationFilter {
   @Autowired
   private UserService userService;

   private static  CustomerFormAuthenticationFilter cu;

   @PostConstruct
   private   void  init(){
       cu=this;
      cu.userService= this.userService;
   }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        isHave(username,password);
        return super.onAccessDenied(request,response);
    }

    private void isHave(String username,String password){
        if (username!=null&&password!=null){
            if ( cu.userService.findOne(username)==null){
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setRoleId(2);
                cu.userService.addUser(user);

            }
        }
    }
}
