// https://eth-ropsten.alchemyapi.io/v2/VKt8meXT6sTTt_yXZf_b5xmGSx7AJrJU

// 스마트컨트렉트 계약 배포를 위한 패키지
require('@nomiclabs/hardhat-waffle');

module.exports = {
  solidity: '0.8.0',
  networks: {
    ropsten: {
      url: 'https://eth-ropsten.alchemyapi.io/v2/VKt8meXT6sTTt_yXZf_b5xmGSx7AJrJU',
      accounts: ['fa1a300d96960ba804ef8f0269583a966d737f5c277793fc876fa2cf2bcc8a92'],
    },
  },
};