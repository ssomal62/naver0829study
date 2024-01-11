import React from "react";
import './MyStyle.css';
import img002 from './002.jpg';
import img004 from './004.jpg';
import {getFCP} from "web-vitals";

let FirstComponent=()=>{

    return(
        <div className="box">
            <h3 className="alert alert-info">First Component 컴포넌트</h3>
            <h6>public의 이미지 나타내기</h6>
            {/*public 이미지는 직접 경로로 지정해야함 - 권장하지 않음*/}
            <img alt="" src="./003.jpg" style={{width : '80%', border : '1px solid gray'}} />

            <h6>src의 이미지 나타내기</h6>
            <img alt="" src={img002} style={{width : '80%', border : '1px solid gray'}} />
            <img alt="" src={img004} style={{width : '80%', border : '1px solid gray'}} />
        </div>
    )
}


export default FirstComponent;