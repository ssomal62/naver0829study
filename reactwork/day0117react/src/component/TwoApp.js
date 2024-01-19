import React, {useEffect, useState} from 'react';
import axios from "axios";
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import ImageListItemBar from '@mui/material/ImageListItemBar';
import ListSubheader from '@mui/material/ListSubheader';
import IconButton from '@mui/material/IconButton';
import InfoIcon from '@mui/icons-material/Info';


const TwoApp = () => {
    const [personList, setPersonList] = useState([]);


    const list = async ()=> {
        const res = await axios.get("/person/list");
        setPersonList(res.data);
    }

    useEffect(() => {
        list(); //처음 시작시 무조건 호출
    },[]); // '[]'안에 아무 것도 쓰지 않으면 처음 시작시 한번만 호출



    return (
        <div>
            <h3 className='alert alert-success'>TwoApp - ImageList에 목록 출력하기</h3>

            <ImageList sx={{ width: 500, height: 450 }}>
                <ImageListItem key="Subheader" cols={2}>
                    <ListSubheader component="div">Person 회원</ListSubheader>
                </ImageListItem>
                {personList.map((item, idx) => (
                    <ImageListItem key={idx}>
                        <img
                            srcSet={require(`../images/${item.photo}?w=248&fit=crop&auto=format&dpr=2 2x`)}
                            src={`../images/${item.photo}?w=248&fit=crop&auto=format`}
                            alt={item.name}
                            loading="lazy"
                        />
                        <ImageListItemBar
                            title={item.name}
                            subtitle={item.age}
                            actionIcon={
                                <IconButton
                                    sx={{ color: 'rgba(255, 255, 255, 0.54)' }}
                                    aria-label={`info about ${item.name}`}
                                >
                                    <InfoIcon />
                                </IconButton>
                            }
                        />
                    </ImageListItem>
                ))}
            </ImageList>
        </div>
    );
};

export default TwoApp;
