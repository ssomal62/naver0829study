import React, {useState} from 'react';


const PersonForm = ({onSave}) => {

    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [photo, setPhoto] = useState('1.jpg');
    const [mbti, setMbti] = useState('ENFP');

    //추가 버튼 이벤트
    const addButtonEvent = () => {

        if(isNaN(age)) {
            alert("나이는 숫자로만 입력해주세요.")
            return;
        }

        //자식엡에서 부모 컴포넌트의 메서드를 통해 입력한 데이터를 부모 컴포넌트로 보낸다.
        onSave({name, age, mbti, photo})

        //key와 value가 다르면 아래처럼 선언
        //onSave({name : tName, age : tAge})


        //초기화
        setName('');
        setAge('');
    }

    return (
        <table className='table table-bordered' style={{width:'600px'}}>
            <tbody style={{textAlign:'center', verticalAlign:'middle'}}>
            <tr>
                <th style={{width:'80px'}}>이름</th>
                <td style={{width:'150px'}}>
                    <input type='text' className='form-control'  value={name} onChange={(e)=> setName(e.target.value)}/>
                </td>
                <th style={{width:'80px'}}>나이</th>
                <td style={{width:'150px'}}>
                    <input type='text' className='form-control'  value={age} onChange={(e)=> setAge(e.target.value)}/>
                </td>
            </tr>
            <tr>
                <th style={{width:'80px'}}>MBTI</th>
                <td style={{width:'150px'}}>
                   <select className='form-select' onChange={(e) => setMbti(e.target.value)} >
                       <option>INTP</option>
                       <option>ENFJ</option>
                       <option selected>ENFP</option>
                       <option>ESTP</option>
                   </select>
                </td>
                <th style={{width:'100px'}}>Photo</th>
                <td style={{width:'150px'}}>
                    <div className='input-group'>
                    <img alt='' src = {require(`../images/${photo}`)} width ='40'  />
                    <select className='form-select' onChange={(e) => setPhoto(e.target.value)} >
                        {
                            [...new Array(20)].map((photo, idx) =>
                                <option key={idx}>
                                    {idx+1}.jpg
                                </option>

                            )
                        }
                    </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td colSpan={4} align='center'>
                    <button type='button' className='btn btn-outline-danger'
                    onClick={addButtonEvent}>추가</button>
                </td>
            </tr>
            </tbody>
        </table>
    );
};

export default PersonForm;
