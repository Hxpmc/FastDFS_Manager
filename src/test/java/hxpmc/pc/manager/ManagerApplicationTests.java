package hxpmc.pc.manager;

import hxpmc.pc.manager.service.Impl.UserServiceImpl;
import hxpmc.pc.manager.untils.UploadUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.csource.common.MyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerApplicationTests {
	@Autowired
	UserServiceImpl userdao;
	@Autowired
	SessionDAO sessionDAO;
	@Test
	public void contextLoads() {
		sessionDAO.getActiveSessions();


	}
}
