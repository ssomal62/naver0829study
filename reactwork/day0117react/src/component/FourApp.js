import React, {useEffect, useState} from 'react';
import FourGuestForm from "./FourGuestForm";
import axios from "axios";
import FourGuestRowItem from "./FourGuestRowItem";


const FourApp = () => {

    const [guestList, setGuestList] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [postsPerPage] = useState(5);
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
        list();
    }, [currentPage]); // currentPage가 변경될 때마다 list() 호출

    // 페이징 로직
    const indexOfLastPost = currentPage * postsPerPage;
    const indexOfFirstPost = indexOfLastPost - postsPerPage;
    const currentPosts = guestList.slice(indexOfFirstPost, indexOfLastPost);

    // 페이지 번호 클릭할 때 호출되는 함수
    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    return (
        <div>
            <h3 className='alert alert-info'>FourApp</h3>
            <FourGuestForm onSave={onGuestSave}/>
            <hr />
            <h6>총 {guestList.length}개의 방명록 글이 있습니다.</h6>
            {/* 현재 페이지에 해당하는 게시물만 렌더링 */}
            {
                currentPosts.map((item, idx) =>
                    <FourGuestRowItem key={idx} item={item} onDelete={onDelete} />)
            }
            {/* 페이지 번호 목록 */}
            <div>
                {[...Array(Math.ceil(guestList.length / postsPerPage)).keys()].map((number) => (
                    <span key={number} style={{ cursor: 'pointer' }} onClick={() => paginate(number + 1)}>
                        <span style={{marginRight:'15px', color:'blue'}}> {number + 1}</span>
                    </span>
                ))}
            </div>
        </div>
    );
};

export default FourApp;
