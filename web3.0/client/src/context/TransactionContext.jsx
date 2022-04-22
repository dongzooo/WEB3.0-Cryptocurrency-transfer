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
  
    console.log({
        provider,
        signer,
        transactionContract
    });
  };

  export const TransactionsProvider = ({ children }) =>{

    const checkIfWalletIsConnected = async () => (
        if (!ethereum) return alert("Please install MetaMask.");

        const accounts = await ethereum.request({ method: "eth_requestAccounts", });

    )
    return (
        <TransactionContext.Provider value= {{ value : 'test'}} >
            {children}
        </TransactionContext.Provider>
      );
  };