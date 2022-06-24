package com.databaseServer.service;

import com.databaseServer.dto.MemberDTO;
import com.databaseServer.model.Member;

public interface MemberService {
	//데이터 삽입
	public String registerMember(MemberDTO dto);
	public MemberDTO loginMemer(MemberDTO memberDTO);
	public MemberDTO getMemer(MemberDTO memberDTO);
	public String updateMember(MemberDTO dto);
	public String deleteMember(MemberDTO dto);
	
	//DTO 클래스의 객치를 Model 클래스의 객체로 변환
	public default Member dtoToEntity(MemberDTO dto) {
		Member member = Member.builder()
				.name(dto.getName())
				.lastlogindate(dto.getLastlogindate())
				.build();
		
		return member;
	}
	
	//Model 객체를 DTO 클래스로 변환
	public default MemberDTO entityToDto(Member member) {
		MemberDTO dto = MemberDTO.builder()
				.name(member.getName())
				.regdate(member.getRegDate())
				.lastlogindate(member.getLastlogindate())
				.build();
		
		return dto;
	}
}
