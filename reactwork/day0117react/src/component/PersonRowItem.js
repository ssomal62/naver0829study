import React from 'react';

const PersonRowItem = (props) => {

    const {row, idx, onDelete} = props;

    return (
        <tr>
            <td style={{width:'200px'}}>
                <img alt='' src = {require(`../images/${row.photo}`)} style={{width:'200px'}}/>
            </td>
            <td valign='middle'>
                <h5>번호 : {idx + 1}</h5>
                <h5>이름 : {row.name}</h5>
                <h5>나이 : {row.photo}</h5>
                <h5>MBTI : {row.mbti}</h5>
                <h6>등록일 : {row.writeDay}</h6>

                <button type='button' className='btn btn-outline-info' onClick={ () =>  onDelete(row.pnum)}> 회원 삭제</button>
            </td>
        </tr>
    );
};

export default PersonRowItem;
