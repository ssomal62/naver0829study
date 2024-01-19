import React from 'react';
import Menu from "./components/Menu";
import {Route, Routes} from "react-router-dom";
import {About, Home, Product} from "./pages";




const RouterMain = () => {
    return (
        <div>
            <Menu />
            <hr style={{clear:'both'}} />
            {/* element 에 내가 넣고 싶은 태그나 컴포넌트 주입 */}
            <Routes>
                {/*<Route path = "/" element={<Home />} />*/}

                {/* Home 에 서브메뉴를 만들고자 할경우 아래와 같이 선언 */}
                <Route path = "/home/*" element={<Home />} />

                {/*<Route path = "/about/:emp" element={<About />} />*/}
                <Route path = "/about" element={<About/>} >
                    <Route path = ":emp" element={<About/>} />
                </Route>

                <Route path = "/product" element={<Product />}>
                    <Route path = ":pd1" element={<Product />} />
                    <Route path = ":pd1/:pd2" element={<Product />} />
                </Route>

                {/*  그 이외의 매핑주소로 되어있을 경우  */}
                <Route path = '*' element = {
                    <div>
                        잘못된 URL 주소입니다.<br />
                        <img alt='' src = {require(`../src/images/404.png`)} />
                    </div>
                } />

            </Routes>


        </div>
    );
};

export default RouterMain;

//
