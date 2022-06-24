package com.databaseServer.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.databaseServer.dto.MemberDTO;
import com.databaseServer.model.Member;
import com.databaseServer.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	@Override
	public String registerMember(MemberDTO dto) {
		Member member = dtoToEntity(dto);
		//이메일 중복 체크
//		Optional<Member> optional = memberRepository.findById(dto.getEmail());
//		if(optional.isPresent()) {
//			return "존재하는 이메일";
//		}
		//지갑주소(name) 중복 체크
		List<Member> list = memberRepository.findMemberByName(dto.getName());
		if(list.size() > 0) {
			return "존재하는 이름";
		}
		
		memberRepository.save(member);
		return member.getName();
	}

	@Override
	public MemberDTO loginMemer(MemberDTO memberDTO) {
		//지갑주소(name)을 가지고 데이터를 찾아옵니다.
		Optional <Member> optional = 
				memberRepository.findById(memberDTO.getName());
		//존재하는 지갑주소(name)
		if(optional.isPresent()) {
			//비밀번호 확인
			Member member = optional.get();
			if(member != null) {
				//로그인에 성공했을 때 로그인 한 시간을 업데이트
				ZonedDateTime nowUTC = ZonedDateTime.now(ZoneId.of("UTC"));
				LocalDateTime now = nowUTC.withZoneSameInstant(
						ZoneId.of("Asia/Seoul")).toLocalDateTime();
				Member updateMember = Member.builder()
						.name(member.getName())
						.lastlogindate(now)
						.build();
				memberRepository.save(updateMember);
				
				return entityToDto(member);
			}else {
				return null;
			}
		}
		//존재하지 않는 이메일
		else {
			return null;
		}
	}

	@Override
	public MemberDTO getMemer(MemberDTO memberDTO) {
		//지갑주소(name)을 가지고 데이터를 찾아옵니다.
		Optional <Member> optional = 
				memberRepository.findById(memberDTO.getName());
		//존재하는 지갑주소(name)
		if(optional.isPresent()) {
			//비밀번호 확인
			Member member = optional.get();
			return entityToDto(member);
		}else {
			return null;
		}
	}

	@Override
	public String updateMember(MemberDTO dto) {
		Member member = dtoToEntity(dto);
		memberRepository.save(member);
		return member.getName();
	}

	@Override
	public String deleteMember(MemberDTO dto) {
		Member member = dtoToEntity(dto);
		memberRepository.delete(member);
		return member.getName();
	}

}
