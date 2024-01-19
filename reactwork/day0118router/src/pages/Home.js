import React from 'react';
import {Alert} from "@mui/material";
import {NavLink, Route, Routes} from "react-router-dom";
import HomeSub1 from "./HomeSub1";
import HomeSub2 from "./HomeSub2";
import HomeSub3 from "./HomeSub3";
import {Checkbox} from "@nextui-org/react";
import {HeartIcon} from './HeartIcon.jsx';
import {PlusIcon} from './PlusIcon.jsx';

const Home = () => {
    return (
        <div>
            <Alert severity='success' variant='filled'> Home component 입니다.</Alert>

            <h2>서브 메뉴들</h2>
            <NavLink to={"/home/sub1"} >연혁</NavLink>
            &nbsp;&nbsp;
            <NavLink to={"/home/sub2"} >회사구조</NavLink>
            &nbsp;&nbsp;
            <NavLink to={"/home/sub3"} >오시는길</NavLink>
            <br/><br/>

            <div className="flex gap-4">
                <Checkbox defaultSelected icon={<HeartIcon/>}>Option</Checkbox>
                <Checkbox defaultSelected icon={<PlusIcon/>} color="warning">Option</Checkbox>
            </div>

            <Routes>
                <Route path = 'sub1' element={<HomeSub1/>} />
                <Route path = 'sub2' element={<HomeSub2/>} />
                <Route path = 'sub3' element={<HomeSub3/>} />
            </Routes>

        </div>
    );
};

export default Home;
