const main = async () => {
  //계약을 위한 인스턴스를 생성하기 위한 인스턴스가 필요
  const Transactions = await hre.ethers.getContractFactory("Transactions");
  const transactions = await Transactions.deploy();

  await transactions.deployed();

  console.log("Transactions deployed to:", transactions.address);
}

// 예외처리
const runMain = async () => {
  try {
    await main();
    process.exit(0);

  } catch (error) {
    console.error(error);
    process.exit(1);
  }
};

runMain();