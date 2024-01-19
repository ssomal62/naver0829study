import React, {useState} from "react";

const SevenApp = (props)=> {

    const [array, setArray] = useState([
        {title : '사진1', price : '23000', color:'orange', photo:'1'},
        {title : '사진2', price : '34000', color:'pink', photo:'11'},
        {title : '사진3', price : '45000', color:'green', photo:'21'},
        {title : '사진4', price : '56000', color:'purple', photo:'29'}

    ]);

   // const [data, setData] = useState('');

    return (
        <div>
           <h3 className='alert alert-info'>SevenApp - 배열 출력</h3>
            <table className='table table-bordered' style={{width:'300px'}}>
                <tbody>
                {
                    array.map((item, idx)=> (
                        <tr key={idx}>
                            <td>
                            <img alt="" src = {require(`../images/${item.photo}.jpg`)} style={{width:'150px'}}/>
                            </td>
                            <td>
                                제목 : {item.title}<br/>
                                가격 : {item.price}<br/>
                                색상 : <b style={{backgroundColor:item.color}}> {item.price}</b><br/>
                                <button type='button' className='btn btn-danger btn-sm'
                                onClick={(e)=>{
                                    setArray(array.filter((item2, idx2)=> (idx !== idx2)))
                                }}
                                >Delete</button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}
export {SevenApp}