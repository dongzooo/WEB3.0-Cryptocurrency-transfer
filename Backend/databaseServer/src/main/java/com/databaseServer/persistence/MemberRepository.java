package com.databaseServer.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.databaseServer.model.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
		//회원 가입을 하는 경우 주소 중복 체크를 위한 메서드
		//기본키를 제외한 다른 컬럼을 가지고 조회를 할 때는 몇개가 나올지 모르기 때문에
		//리턴 타입은 List
		List<Member>  findMemberByName(String name);
}
