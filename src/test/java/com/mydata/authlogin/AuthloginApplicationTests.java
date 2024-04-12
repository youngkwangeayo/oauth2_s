package com.mydata.authlogin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mydata.authlogin.entity.Member;
import com.mydata.authlogin.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

// import lombok.extern.java.Log;

@Slf4j
@SpringBootTest
class AuthloginApplicationTests {

	@Autowired
	MemberMapper memberMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void mamberMapperTest(){

		Member m = memberMapper.findMemberByEmail("test@gmail.com");
		String d = memberMapper.mapping("test@gmail.com");
		
		// assert
		// log.info("member",d);
		assertNotNull(m);
		


	}

}
