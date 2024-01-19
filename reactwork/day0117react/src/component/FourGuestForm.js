import React, {useRef, useState} from 'react';
import axios from "axios";

const FourGuestForm = ({onSave}) => {

    const [photo, setPhoto] = useState('');
    const [nickName, setNickname] = useState('');
    //const [content, setContent] = useState('');

    const imgUrl = "https://kr.object.ncloudstorage.com/bitcamp701aiur/bootmyshop/";

    const contentRef = useRef('');

    const onUploadEvent= async (e) => {

        const uploadFile = new FormData();
        uploadFile.append("upload", e.target.files[0]);


        // axios({
        //     method : 'post',
        //     url:"/guest/upload",
        //     data : uploadFile,
        //     headers : { 'Content-Type': 'multipart/form-data'}
        // }).then(res => {
        //     console.log(res.data);
        //     setPhoto(res.data);
        // })


        const res = await axios.post("/guest/upload", uploadFile, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });

        setPhoto(res.data) //실제 스토리지에 올라간 사진 파일명 반환
    }

    const addButtonEvent= ()=> {
        let content = contentRef.current.value;
        if(nickName.length === 0 || content.length === 0) {
            alert('모든 항목을 입력해주세요');
            return;
        }

        onSave({nickName, content});

        //입력값 초기화
        setNickname('');
        contentRef.current.value = '';
        setPhoto('');

    }

    return (
        <div>
            <div style={{width:'300px'}}>
            <input type='file' className='form-control'  onChange={onUploadEvent} />
            <img alt='' src = {imgUrl+photo} width='130' />
                {photo}
            </div>
            <div style={{width:'400px'}} className='input-group'>
                <input type='text' placeholder='닉네임' value = {nickName}
                onChange={(e)=> setNickname(e.target.value)}
                className='form-control'/>
                <button className='btn btn-outline-secondary' type='button' onClick={addButtonEvent}> 추가 </button>
            </div>
            <textarea className='form-control' onChange={(e)=> {contentRef.current.value= e.target.value}}
                   ref = {contentRef}  style={{width:'400px'}} placeholder='방명록 내용 입력'></textarea>

        </div>
    );
};

export default FourGuestForm;
