import React from 'react'
import ReactDOM from 'react-dom'
// import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import { TransactionsProvider } from "./context/TransactionContext";

ReactDOM.render(
  <TransactionsProvider>
     <React.StrictMode>
      <App />
    </React.StrictMode>
  </TransactionsProvider>,
  document.getElementById("root")
);
