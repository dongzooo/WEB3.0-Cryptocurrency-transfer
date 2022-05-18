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


/* transactionContract 에서 사용가능한 함수 정리
addToBlockchain: ƒ (...args)
addToBlockchain(address,uint256,string,string): ƒ (...args)
address: "0xB80Ff80f98e25F023EF85175e61aAff7a5337Fe6"
callStatic: {addToBlockchain(address,uint256,string,string): ƒ, getAllTransactions(): ƒ, getTransactionCount(): ƒ, addToBlockchain: ƒ, getAllTransactions: ƒ, …}
estimateGas: {addToBlockchain(address,uint256,string,string): ƒ, getAllTransactions(): ƒ, getTransactionCount(): ƒ, addToBlockchain: ƒ, getAllTransactions: ƒ, …}
filters: {Transfer(address,address,uint256,string,uint256,string): ƒ, Transfer: ƒ}
functions: {addToBlockchain(address,uint256,string,string): ƒ, getAllTransactions(): ƒ, getTransactionCount(): ƒ, addToBlockchain: ƒ, getAllTransactions: ƒ, …}
getAllTransactions: ƒ (...args)
getAllTransactions(): ƒ (...args)
getTransactionCount: ƒ (...args)
getTransactionCount(): ƒ (...args)
interface: Interface {fragments: Array(4), _abiCoder: AbiCoder, functions: {…}, errors: {…}, events: {…}, …}
populateTransaction: {addToBlockchain(address,uint256,string,string): ƒ, getAllTransactions(): ƒ, getTransactionCount(): ƒ, addToBlockchain: ƒ, getAllTransactions: ƒ, …}
provider: Web3Provider {_isProvider: true, _events: Array(0), _emitted: {…}, disableCcipRead: false, formatter: Formatter, …}
resolvedAddress: Promise {<fulfilled>: '0xB80Ff80f98e25F023EF85175e61aAff7a5337Fe6'}
signer: JsonRpcSigner {_isSigner: true, provider: Web3Provider, _index: 0, _address: null}
_runningEvents: {}
_wrappedEmits: {}
[[Prototype]]: BaseContract
*/