import React, {useState} from "react";
import {Button} from "@mui/material";

const E_WriteForm = ({onSave}) => {

    const [fname, setFname] = useState('');
    const [fphoto, setFphoto] = useState('2.jpg');
    const [fprice, setFprice] = useState(0);

    const onAddEvent= () => {
        onSave({fname, fphoto, fprice});

        //초기화
        setFname('');
        setFprice(0);
    }

    return(
        <div className='input-group'>
            메뉴명 :
            <input type='text' value={fname} onChange={(e)=> setFname(e.target.value)}
                   style={{width:'100px'}} />

            가격 :
            <input type='text'
                   value={fprice} onChange={(e)=> setFprice(e.target.value)} style={{width:'70px'}} />

            사진 :
            <select onChange={(e)=> setFphoto(e.target.value)}>
                <option value={'2.jpg'}>사진1</option>
                <option value={'12.jpg'}>사진2</option>
                <option value={'15.jpg'}>사진3</option>
                <option value={'20.jpg'}>사진4</option>
            </select>
            <Button color='warning' varuabt='outlined' size = "small" onClick ={onAddEvent}>추가</Button>
        </div>
    )
}

export default E_WriteForm