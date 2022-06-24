package com.databaseServer;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.databaseServer.model.Member;
import com.databaseServer.model.TransferInfo;
import com.databaseServer.persistence.MemberRepository;
import com.databaseServer.persistence.TransferInfoRepository;

@SpringBootTest
public class RepositoryTest {
	@Autowired
	private MemberRepository memberRepository;

	//Member에 데이터 삽입
//	@Test
	public void testRegisterMember() {
		Member member = 
				Member.builder()
				.name("0xCfaf7807a841389433a338Aa70fEB6348E77e8ca")
				.build();
		memberRepository.save(member);
	}

	//주소로 데이터 조회
//	@Test
	public void testFindName() {
		String name = "0xCfaf7807a841389433a338Aa70fEB6348E77e8ca";
		List<Member> list = memberRepository.findMemberByName(name);
		System.out.println(list);
		
		name = "군계";
		list = memberRepository.findMemberByName(name);
		System.out.println(list);
		
		if(list.size() > 0) {
			System.out.println("데이터가 존재합니다.");
		}else {
			System.out.println("데이터가 존재하지 않습니다.");
		}
		
	}
	
	
	@Autowired
	private TransferInfoRepository transferInfoRepository;

	//TransferInfo삽입 테스트
//	@Test
	public void testInsertTransferInfo() {
		//외래키를 생성
		Member member = Member.builder()
				.name("0xCfaf7807a841389433a338Aa70fEB6348E77e8ca")
				.build();
		for(int i=0; i<100; i++) {
			TransferInfo transferInfo = TransferInfo.builder()
					.addressto("0x"+Integer.toString((int)(Math.random()*100)) +"b89f26f5d635fcAFcBF929136F88c8CCc94E2803")
					.amount((double)((Math.random()*10000)%10))
					.description("transfer to my account")
					.member(member)
					.build();
			transferInfoRepository.save(transferInfo);
		}
	}
	
	
}
