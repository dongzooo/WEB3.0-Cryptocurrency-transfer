import abi from "./Transactions.json";

// abi는 계약 어플리케이션이다
// 밑에 계약주소 유일한게 아니라 배포하면 아래 주소에 이더리움 네트워크에서 블록체인 계약을 위한 정보들이 저장됌

// smart_contract\artifacts\contracts\Transactions.sol\Transactions.json 파일에 추가적으로 저장된다

export const contractABI = abi.abi;
export const contractAddress = "0xB80Ff80f98e25F023EF85175e61aAff7a5337Fe6";