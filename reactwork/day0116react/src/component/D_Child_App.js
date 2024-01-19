import React from "react";
import {Button} from "@mui/material";

const D_Child_App = (props) => {

    const {name, age, addr} = props;  //출력만 가능, 수정은 불가능 (읽기전용)

    return(
        <div className='box'>
            {name}님의 나이는 {age}이며 고향은 {addr}.
            <Button color='info' variant='outlined' size='small'
            onClick = {() => props.incre()}>증가</Button>
        </div>
    )
}

export default D_Child_App;