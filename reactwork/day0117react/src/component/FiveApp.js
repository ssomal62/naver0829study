import React, {useEffect, useState} from 'react';
import axios from "axios";
import FourGuestForm from "./FourGuestForm";
import FourGuestRowItem from "./FourGuestRowItem";

const FiveApp = () => {
    const [guestList, setGuestList] = useState([]);

    const [visiblePosts, setVisiblePosts] = useState(5);
    const [postsPerPage] = useState(5);

    //저장 함수
    const onGuestSave = async (data) => {
        const res = await axios.post("/guest/insert", data);
        list();
    }

    const list = async () => {
        const res = await axios.get("guest/list");
        setGuestList(res.data);
    }

    const onDelete = async (gnum) => {
        const a = window.confirm("삭제?")

        if(a) {
            const res = await axios.delete("guest/delete", { params: { gnum } });
            list();
        }
    }

    useEffect(() => {
        list()
    },[]);// 처음 렌더링 시에만 호출

    const loadMore = () => {
        setVisiblePosts(visiblePosts + postsPerPage);
    };


    return (
        <div>
            <h3 className='alert alert-info'>FourApp</h3>
            <FourGuestForm onSave={onGuestSave}/>
            <hr />
            <h6>총 {guestList.length}개의 방명록 글이 있습니다.</h6>

            {/* 현재까지 visiblePosts까지의 게시물만 렌더링 */}
            {guestList.slice(0, visiblePosts).map((item, idx) => (
                <FourGuestRowItem key={idx} item={item} onDelete={onDelete} />
            ))}
            {/* "더보기" 버튼 */}
            {visiblePosts < guestList.length && (
                <button onClick={loadMore}>더보기</button>
            )}

        </div>
    );
};

export default FiveApp;
