import React, {useDebugValue, useState} from "react";
import {Button} from "@mui/material";
const C_App = (props) => {

    const [inputArray, setInputArray] = useState([]);

    //객체를 갖는 상태 변수
    const [inputs, setInputs] = useState({
        name:'',
        nickName:'',
        hp:'',
        addr:''
    })

    //입력시 inputs의 해당 멤버변수로 값이 들어가게 하기 위한 이벤트
    const inputChangeEvent = (e)=> {
        const {name, value} = e.target; //이벤트가 발생하는 태그의 name 과 value 값을 얻음.

        setInputs({
            ...inputs,       // 1. 기존의 값을 펼침 연산자로 일단 넣고
            [name] : value   // 2. 입력한 태그의 name에 값 변경
        })
    }

    //배열 추가 이벤트
    const addArrayEvent = () => {
        //기존 배열 데이터에 묶음 변수인 inputs 추가
        setInputArray(inputArray.concat(inputs));
    }

    //입력값 초기화
    const clearFormEvent = ()=> {
        setInputs({
            name:'',
            nickName: '',
            hp: '',
            addr : ''
        })
    }

    //삭제 이벤트에서 호출해야함
    const deleteData= (deleteIdx) =>{
        setInputArray(inputArray.filter((array, idx) => deleteIdx !== idx));
    }

    return(
        <div>
            <h3 className='alert alert-danger'>C : 하나의 변수에 여러 데이터 저장하기</h3>

            <div style={{width:'450px'}}>
                이름<input type='text' className='form-control' value = {inputs.name} name='name' onChange={inputChangeEvent}/>
                닉네임<input type='text' className='form-control' value = {inputs.nickName} name='nickName' onChange={inputChangeEvent}/>
                연락처<input type='text' className='form-control' value = {inputs.hp} name='hp' onChange={inputChangeEvent}/>
                주소<input type='text' className='form-control' value = {inputs.addr} name='addr' onChange={inputChangeEvent}/>
            </div>
            <br/>
            <Button color='info' variant='outlined' onClick = {addArrayEvent}>배열에 추가</Button>
            <Button color='info' variant='outlined' onClick = {clearFormEvent}>입력값 초기화</Button>
            <hr/>
            <div style={{width:'450px'}}>
                출력 <br/><br/>
                name : {inputs.name}<br/>
                nickName : {inputs.nickName}<br/>
                hp : {inputs.hp}<br/>
                addr : {inputs.addr}<br/>
            </div>
            <hr/>
            <table className='table table-bordered' style={{width:'500px'}}>
                <caption align='top'>데이터 갯수 : {inputArray.length}</caption>
                <thead>
                <tr>
                    <th>이름</th>
                    <th>닉네임</th>
                    <th>hp</th>
                    <th>주소</th>
                </tr>
                </thead>
                <tbody>
                {
                    inputArray.map((item, idx)=>
                        <tr key={idx}>
                            <td>
                                {item.name}
                                <span style={{marginLeft:'10px', cursor:'pointer'}}
                                onClick ={(e) => deleteData(idx)}>🗑️</span>
                            </td>
                            <td>{item.nickName}</td>
                            <td>{item.hp}</td>
                            <td>{item.addr}</td>
                        </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    )
}

export { C_App }