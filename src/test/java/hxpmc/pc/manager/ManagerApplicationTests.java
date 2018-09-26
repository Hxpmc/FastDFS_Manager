package hxpmc.pc.manager;

import hxpmc.pc.manager.service.Impl.UserServiceImpl;
import hxpmc.pc.manager.untils.UploadUtils;
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
	@Test
	public void contextLoads() {
		try {
			String s = UploadUtils.uploadFile("C:\\Users\\Administrator\\Desktop\\403189072846067370.jpg");
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
