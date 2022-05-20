//처음5개와 마지막 4개를 보여준다.
export const shortenAddress = (address) => `${address.slice(0, 5)}...${address.slice(address.length - 4)}`;
