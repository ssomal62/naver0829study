import React, {useEffect, useState} from 'react';

const FourGuestRowItem = ({item, onDelete}) => {

    //.env (공통된 환경변수 등록) - 가져오기
    const imageStorage = process.env.REACT_APP_STORAGE;


    return (
            <div>
                {item.nickName}
                {item.content}
                {item.writeDay}
                <img alt='' src = {imageStorage + item.photo} style={{width:'40px'}}/>
                <span style={{cursor:'pointer'}} onClick={() =>onDelete(item.gnum)}>🗑️</span>
            </div>

    );
};

export default FourGuestRowItem;
