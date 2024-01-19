import React, {useState} from "react";
import E_RowItem from "./E_RowItem";
import E_WriteForm from "./E_WriteForm";

const E_App = (props) => {

    const [photoArray, setPhotoArray]=useState([
        {
            fname : '망고빙수',
            fphoto : '1.jpg',
            fprice : '12000',
            fdate : new Date()
        },
        {
            fname : '샌드위치',
            fphoto : '10.jpg',
            fprice : '9900',
            fdate : new Date()
        }
    ])

    //데이터 추가 이벤트
    const dataAdd = (data) => {
        setPhotoArray(photoArray.concat({
            ...data,
            fdate : new Date()
        }))
    }

    const deleteData = (deleteIdx) => {
        setPhotoArray(photoArray.filter((array, idx) => deleteIdx !== idx));
    }

    return(
        <div>
            <h3 className='alert alert-danger'>FiveApp - 부모 자식 간 통신 예제</h3>

            {/*입력 폼*/}
            <E_WriteForm onSave = {dataAdd}/>
             <br/>

            <table className='table table-bordered' style={{width:'400px'}}>
                <thead>
                <tr style={{backgroundColor:'palegoldenrod'}}>
                    <th>번호</th>
                    <th>메뉴명</th>
                    <th>가격</th>
                    <th>날짜</th>
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody>
                    {
                        photoArray.map((data, idx)=>(<E_RowItem row={data} idx={idx} onDelete={deleteData}/>))
                    }
                </tbody>
            </table>
        </div>
    )
}

export { E_App }