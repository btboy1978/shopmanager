package org.iley.app;

import org.iley.app.model.OfficeGroup;
import org.iley.app.model.SysUser;
import org.iley.app.service.impl.SysUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopManager.class)
public class ShopManagerTest {

	@Autowired
	private SysUserServiceImpl sysUserServiceImpl;

	@Test
	public void importShopData() {

	}

	@Test
	public void initAdminUser() {

		SysUser user = new SysUser();
		user.setUsername("admin");
		user.setPassword(new StandardPasswordEncoder("24729138").encode("admin"));
		user.setAddress("湖北省武汉市江岸区堤角前街11号");
		user.setCnname("李曦");
		user.setEmail("btboy1978@gmail.com");
		user.setMobilePhone("1350*****45");
		user.setOfficeGroup(new OfficeGroup("信息部"));
		user.addRole("ADMIN");
		user.setTelephone("027-82316618");

		sysUserServiceImpl.save(user);
	}

}
