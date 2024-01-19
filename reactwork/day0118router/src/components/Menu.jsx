import React from 'react';
import '../pages/MyStyle.css'
import {NavLink} from "react-router-dom";
const Menu = () => {
    return (
        <div>
            <ul className='menu'>
                <li>
                    {/*  <a>태그 사용 불가  */}
                    <NavLink to={"/home"}>HOME</NavLink>  {/*  '/' 은 최상위 경로 */}
                </li>
                <li>
                    <NavLink to={"/about/"}>ABOUT</NavLink>
                </li>
                <li>
                    <NavLink to={"/about/Google"}>ABOUT-구글</NavLink>
                </li>
                <li>
                    <NavLink to={"/about/Samsung"}>ABOUT-삼성</NavLink>
                </li>
                <li>
                    <NavLink to={"/product"}>PRODUCT</NavLink>
                </li>
                <li>
                    <NavLink to={"/product/4/11"}>PRODUCT1</NavLink>
                </li>
                <li>
                    <NavLink to={"/product/1"}>PRODUCT2</NavLink>
                </li>

            </ul>
        </div>
    );
};

export default Menu;
