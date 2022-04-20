import React from "react";
import { HiMenuAlt4 } from "react-icons/hi";
import { AiOutlineClose } from "react-icons/ai";

import logo from "D:/git/NFT-DApp/blockChainWeb3/images/logo.png";

const NavBarItem = ({ title, classprops }) => (
    <li className={`mx-4 cursor-pointer ${classprops}`}>{title}</li>
  );

const Navbar = () =>{
    const [toggleMenu, setToggleMenu] = React.useState(false);

    return (
        <nav className="w-full flex md:justify-center justify-between items-center p-4">
          <div className="md:flex-[0.5] flex-initial justify-center items-center">
            <img src={logo} alt="logo" className="w-32 cursor-pointer" />
          </div>
          <ul className="text-white md:flex hidden list-none flex-row justify-between items-center flex-initial">
            {["Market", "Exchange", "Tutorials", "Wallets"].map((item, index) => (
              <NavBarItem key={item + index} title={item} />
            ))}
            <li className="bg-[#2952e3] py-2 px-7 mx-4 rounded-full cursor-pointer hover:bg-[#2546bd]">
              Login
            </li>
          </ul>
          {/* 모바일 친화적인 UI를 위한 메뉴 디자인  */}
          <div className="flex relative">
            {/* 현재 열려있다면 false */}
            {!toggleMenu && (
              <HiMenuAlt4 fontSize={28} className="text-white md:hidden cursor-pointer" onClick={() => setToggleMenu(true)} />
            )}
            {toggleMenu && (
              <AiOutlineClose fontSize={28} className="text-white md:hidden cursor-pointer" onClick={() => setToggleMenu(false)} />
            )}
            {toggleMenu && (
                // 화면비율에 따라 왼쪽 메뉴가 있어졌다 없어지는 이벤트 & 디자인
              <ul
                className="z-10 fixed -top-0 -right-2 p-3 w-[70vw] h-screen shadow-2xl md:hidden list-none
                flex flex-col justify-start items-end rounded-md blue-glassmorphism text-white animate-slide-in"
              >
                <li className="text-xl w-full my-2"><AiOutlineClose onClick={() => setToggleMenu(false)} /></li>
                {["Market", "Exchange", "Tutorials", "Wallets"].map(
                  (item, index) => <NavBarItem key={item + index} title={item} classprops="my-2 text-lg" />,
                )}
              </ul>
            )}
          </div>
        </nav>
      );
};

export default Navbar;