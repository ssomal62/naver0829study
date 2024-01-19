import React, {useEffect, useState} from 'react';
import PersonForm from "./PersonForm";
import axios from 'axios'
import PersonRowItem from "./PersonRowItem";

const OneApp = (props) => {

    const [personList, setPersonList] = useState([]);

    //저장 이벤트
    const personInsert = async (data) => {
        //console.log(data);

        //스프링부트 서버로 데이터 보내서 DB 저장
        // axios.post("/person/add", data)
        //     .then((res) => {
        //         //추가 성공 후 목록 다시 출력 영역
        //         list();
        //     }).catch(error => {
        //         console.log("추가시 에러발생 : " + error);
        // });

        try {
            const res = await axios.post("/person/add", data);

        } catch (error) {
            console.log("추가시 에러발생 : " + error);
        }
        await list();
    }

    const list = async ()=> {

        const res = await axios.get("/person/list");
        setPersonList(res.data);

        // axios.get("/person/list")
        //     .then(res => {
        //         setPersonList(res.data);
        //     })

    }

    useEffect(() => {
        list(); //처음 시작시 무조건 호출
    },[]); // '[]'안에 아무 것도 쓰지 않으면 처음 시작시 한번만 호출

    const deletePerson = async (pnum) => {

        const res = await axios.delete("/person/delete/" + pnum);
        await list();

    }

    return (
        <div>
            <h3 className='alert alert-success'>OneApp -person DB 추가/목록</h3>
            <PersonForm onSave = {personInsert}/>

            <hr/>
            <h5>총 {personList.length}명의 회원이 등록되어있습니다.</h5>
            <table className='table table-bordered' style={{width:'500px'}}>
                <tbody>
                {
                    personList.map((rowData, idx) =>
                        <PersonRowItem key={idx} row={rowData} idx={idx} onDelete={deletePerson}/>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;
