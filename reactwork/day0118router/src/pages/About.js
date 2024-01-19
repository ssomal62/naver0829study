import React from 'react';
import {Alert} from "@mui/material";
import {useParams} from "react-router-dom";
import img1 from '../images/1.jpg'
import img2 from '../images/2.jpg'
const About = () => {

    const {emp} = useParams();
    console.log({emp});
    console.log({emp}, emp);

    return (
        <div>
            <Alert severity='success' variant='filled'> About component 입니다.</Alert>

            {
                emp == null ?
                    //emp값이 null일 때 실행 할 영역
                    <div>
                        <h1>저는 취업준비생입니다.</h1>
                        <img alt='' src = {require('../images/7.jpg')} />
                    </div>
                    :
                    //emp값이 존재할 때 실행 할 영역
                    <div>
                        <h1> 저는 {emp}에 다니고 있습니다.</h1>
                        <img alt='' src={(emp === 'Samsung' ? img1 : img2)}/>
                    </div>
            }
        </div>
    );
};

export default About;
