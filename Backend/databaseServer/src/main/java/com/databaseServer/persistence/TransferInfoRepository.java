package com.databaseServer.persistence;

import java.util.List;

import com.databaseServer.model.Member;
import com.databaseServer.model.TransferInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferInfoRepository extends JpaRepository<TransferInfo, Long>{
	//Member를 이용해서 Member 가 작성한 모든 TransferInfo을 조회하는 메서드
		List<TransferInfo> findTransferInfoByMember(Member member);
}
