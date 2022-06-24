package com.databaseServer.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferInfoDTO {
	private Long transactionid;
	private String addressto;
	private Double amount;
	private String description;
	//Entity 를 만들 때 는 Entity를 외래키로 추가하지만 화면 입출력할 때는 필요한 데이터만 선언
//	private String email;
	private String name;
}
