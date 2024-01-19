import React, {useEffect, useState} from 'react';
import ThreeCardApp from "./ThreeCardApp";
import axios from "axios";
import {Alert} from "@mui/material";

const ThreeApp = () => {

    const [personList, setPersonList] = useState([]);

    const list = async ()=> {
        const res = await axios.get("/person/list");
        setPersonList(res.data);
    }

    useEffect(() => {
        list(); //처음 시작시 무조건 호출
    },[]); // '[]'안에 아무 것도 쓰지 않으면 처음 시작시 한번만 호출



    return (
        <div>
            <h3 className='alert alert-info'>ThreeApp - muicard를 이용한 목록 출력</h3>
            {
                personList.map((item, idx)=>
                    <div>
                    <ThreeCardApp key={idx} item={item} />
                    <hr/>
                    </div>
                )

            }

        </div>
    );
};

export default ThreeApp;
