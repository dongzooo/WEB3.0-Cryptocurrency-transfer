import React, { useEffect, useState } from "react";
import { ethers } from "ethers";

import { contractABI, contractAddress } from "../utils/constants";

export const TransactionContext = React.createContext();

//이더리움의 윈도우 객체에 접근
const { ethereum } = window;

//이더리움 계약 가져오기
const getEthereumContract = () => {
    const provider = new ethers.providers.Web3Provider(ethereum);
    const signer = provider.getSigner();
    //(0xB80Ff80f98e25F023EF85175e61aAff7a5337Fe6, Transacion.json, signer)
    const transactionContract = new ethers.Contract(contractAddress, contractABI, signer);

    return transactionContract;
    // console.log({
    //     provider,
    //     signer,
    //     transactionContract
    // });
  };

//export data
export const TransactionsProvider = ({ children }) =>{
    //useState필드 설정
    const [currentAccount, setCurrentAccount] = useState('');
    const [formData, setformData] = useState({ addressTo: "", amount: "", keyword: "", message: "" });
    const [isLoading, setIsLoading] = useState(false);
    //거래를 localStorage에 저장한다.
    const [transactionCount, setTransactionCount] = useState(localStorage.getItem("transactionCount"));

    // 이벤트 핸들 변경
    // Welcome 화면 이더리움 카드의 계좌, 잔고, 메세지 등 정보 전달 및 동적 업데이트
    const handleChange = (e, name) => {
        //이전상태 => 값
        setformData((prevState) => ({ ...prevState, [name]: e.target.value }));
      };


    //지갑 연결여부 확인
    const checkIfWalletIsConnected = async () => {

        try {
            if(!ethereum) return alert("Please install MetaMask.");

            const accounts = await ethereum.request({ method: "eth_requestAccounts" });
            
            if(accounts.length){
                setCurrentAccount(accounts[0]);
                //getAllTransaction
            }else{
                console.log('No accounts found')
            }
            console.log(accounts);

        } catch (error) {
            console.log(error);
            throw new Error("No ethereum object");
        }  
    }

    const sendTransaction = async () => {
        try {
            if(!ethereum) return alert("Please install MetaMask.");

            //get the data from the form
            const { addressTo, amount,  keyword, message} = formData;
            const transactionContract = getEthereumContract();
            //십진수인 값을 이더네트워크에서 사용하기 위해 16진수로 파싱한다
            const parsedAmount = ethers.utils.parseEther(amount);

            await ethereum.request({
                method : 'eth_sendTransaction',
                
                params :[{
                    from : currentAccount,
                    to : addressTo,
                    gas: "0x5208",//다스한도 설정 : 21000GEWI hex 16진수로 21000이지만 이더리움상에서는 0.000021ETH이다
                    value : parsedAmount._hex, // 0.00001
                }]
            });

            //transaction.sol 파일의 블록체인 구조체의 형태로 전송
            const transactionHash = await transactionContract.addToBlockchain( addressTo, amount, message, keyword);
            setIsLoading(true);
            console.log(`Loading - ${transactionHash.hash}`);
            await transactionHash.wait();
            setIsLoading(false);
            console.log(`Success - ${transactionHash.hash}`);
            
            //거래 횟수
            const transactionsCount = await transactionContract.getTransactionCount();

            setTransactionCount(transactionsCount.toNumber());
            window.location.reload();

        } catch (error) {
            console.log(error);
            throw new Error("No ethereum object");
        }  
        
      };

    //지갑연결
    const connectWallet = async () => {
        try {
          if (!ethereum) return alert("Please install MetaMask.");
    
          const accounts = await ethereum.request({ method: "eth_requestAccounts" });
            
          
          //첫번쨰 계정 연결
          setCurrentAccount(accounts[0]);
          //window.location.reload();
        } catch (error) {
          console.log(error);
    
          throw new Error("No ethereum object");
        }
    }

    useEffect(() => {
            checkIfWalletIsConnected();
        }, []);

    return (
        //지갑연결 값
        <TransactionContext.Provider value= {{ 
            connectWallet , currentAccount, formData, setformData, handleChange, sendTransaction
            }} >
            
            {children}
        </TransactionContext.Provider>
      );

  };

