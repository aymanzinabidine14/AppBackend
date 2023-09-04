package com.doodle.backend;

import com.doodle.backend.entities.Option;
import com.doodle.backend.entities.Sandage;
import com.doodle.backend.entities.User;
import com.doodle.backend.services.OptionServiceImp;
import com.doodle.backend.services.SandageServiceImp;
import com.doodle.backend.services.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	OptionServiceImp optionServiceImp;
	@Autowired
	UserServiceImp userServiceImp;
	@Autowired
	SandageServiceImp sandageServiceImp;
	@Test
	void contextLoads() {

			/*Option option=optionServiceImp.getOption(1L);
			Sandage sandage=sandageServiceImp.getSandage(1L);
			sandage.setBooking(option);
			sandageServiceImp.saveSandage(sandage);*/
		optionServiceImp.deleteOptionById(63L);


	}





}
