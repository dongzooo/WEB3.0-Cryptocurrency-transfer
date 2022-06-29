package com.databaseServer.service;

import com.databaseServer.dto.PageResponseTransferInfoDTO;
import com.databaseServer.dto.TransferInfoDTO;
import com.databaseServer.model.Member;
import com.databaseServer.model.TransferInfo;

public interface TransferInfoService {
	//아이템 등록
	public Long registerTransferInfo(TransferInfoDTO dto);
	//하나의 아이템 가져오기
	public TransferInfoDTO getTransferInfo(TransferInfoDTO dto);
	//아이템 수정
	public Long updateTransferInfo(TransferInfoDTO dto);
	//아이템 삭제
	public Long deleteTransferInfo(TransferInfoDTO dto);
	//페이지 단위로 데이터를 가져오기
	public PageResponseTransferInfoDTO getListPageRequest (TransferInfoDTO dto);
	
	//DTO를 ENTITY로 변환해주는 메서드
	public default TransferInfo dtoToEntity(TransferInfoDTO dto) {
		TransferInfo transferInfo = TransferInfo.builder()
				.addressto(dto.getAddressto())
				.amount(dto.getAmount())
				.description(dto.getDescription())
				.member(Member.builder().name(dto.getName()).build())
				.build();
		return transferInfo;
				
	}
	
	//Entity를 DTO로 변환해주는 메서드
	public default TransferInfoDTO entityToDto(TransferInfo transferInfo) {
		TransferInfoDTO dto = TransferInfoDTO.builder()
				.addressto(transferInfo.getAddressto())
				.amount(transferInfo.getAmount())
				.description(transferInfo.getDescription())
				.name(transferInfo.getMember().getName())
				.build();
		return dto;
	}
}
