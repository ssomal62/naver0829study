import React, {useRef, useState} from "react";
import {Alert, Button} from "@mui/material";

const A_App = (props) => {

    //count 증가를 두가지로 선언해서 비교

    //1. state
    const [count, setCount] = useState(0);

    //2. useRef
    const countRef = useRef(0);

    return(
        <div>
            <Alert severity='success' variant='filled'>
                A - useRef
            </Alert>
            <h5> state: {count}</h5>
            <h5> useRef: {countRef.current}</h5>

            <hr/>

            <Button variant='outlined' color='success' size='small'
             onClick = {()=>setCount(count + 1)}>count 변수 증가</Button>

            <Button variant='outlined' color='primary' size='small'
            onClick = {() => {
                countRef.current = countRef.current + 1;

                console.log("countRef.current" + countRef.current);
            }
            }>useRef 변수 증가</Button>

        </div>
    )
}

export { A_App }