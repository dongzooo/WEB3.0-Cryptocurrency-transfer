package com.databaseServer.service;

import org.springframework.stereotype.Service;

import com.databaseServer.dto.PageResponseTransferInfoDTO;
import com.databaseServer.dto.TransferInfoDTO;
import com.databaseServer.persistence.MemberRepository;
import com.databaseServer.persistence.TransferInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferInfoServiceImpl implements TransferInfoService {
	
	private final TransferInfoRepository transferInfoRepository;
	
	@Override
	public Long registerTransferInfo(TransferInfoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferInfoDTO getTransferInfo(TransferInfoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateTransferInfo(TransferInfoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteTransferInfo(TransferInfoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResponseTransferInfoDTO getListPageRequest(TransferInfoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
