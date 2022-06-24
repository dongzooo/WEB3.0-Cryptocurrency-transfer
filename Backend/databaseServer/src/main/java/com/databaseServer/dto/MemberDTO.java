package com.databaseServer.dto;

import java.time.LocalDateTime;

import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String name;
	//전송된 파일의 내용을 저장할 속성
	private LocalDateTime lastlogindate;
	private LocalDateTime regdate;
}