// SPDX-License-Identifier: UNLICENSED

pragma solidity ^0.8.0;

contract Transactions {
    // 거래 횟수를 센다
    uint256 transactionCount;

               // (변수이름, 수신, 자료형, 메세지, 시간, 키워드)
    event Transfer(address from, address receiver, uint amount, string message, uint256 timestamp, string keyword);

     struct TransferStruct {
        address sender;
        address receiver;
        uint amount;
        string message;
        uint256 timestamp;
        string keyword;
    }

    TransferStruct[] transactions;

                         // (지불가능한 주소, 금액, 거래 메모리에 저장할 메세지, 메모리 키워드)
    function addToBlockchain(address payable receiver, uint amount, string memory message, string memory keyword) public {
        transactionCount += 1;
        //구조체에 담아 전달
        transactions.push(TransferStruct(msg.sender, receiver, amount, message, block.timestamp, keyword));
        
        //스마트컨트렉트 거래 완료
        emit Transfer(msg.sender, receiver, amount, message, block.timestamp, keyword);
    }

    function getAllTransactions() public view returns (TransferStruct[] memory) {
        return transactions;
    }

    function getTransactionCount() public view returns (uint256) {
        return transactionCount;
    }

}