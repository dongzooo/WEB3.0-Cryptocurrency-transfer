package com.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.model.Member;
import com.backend.persistence.MemberRepository;

@SpringBootTest
public class RepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	//Member에 데이터 삽입
	@Test
	public void testRegisterMember() {
		Member member = 
				Member.builder()
				.name("test_account")
				.build();

		memberRepository.save(member);
	}

}
