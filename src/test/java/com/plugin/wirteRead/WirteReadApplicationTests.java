package com.plugin.wirteRead;

import com.plugin.wirteRead.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WirteReadApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MemberService memberService;



	@Test
	public void testRead() {
		for (int i = 0; i < 4; i++) {
			System.out.println(memberService.find("123"));
		}
	}



}
