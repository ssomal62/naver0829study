import React, {useRef} from "react";
import cate from '../data/CateData.json'

const F_App = (props) => {

    const navData = cate.navData;
    const cateData = cate.categoryData;

    //이미지에 적용할 ref 변수 선언
    const mainPhotoRef = useRef(null);


    return(
        <div>
            <h3 className='alert alert-danger'>json데이터 출력</h3>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        navData.map((item, idx) =>
                            <li key = {idx}>
                                <div><img alt="" src={item.img} className='imgcategory'
                                onClick={(e)=> {
                                    mainPhotoRef.current.src = e.target.src;
                                }}/></div>
                                <div style={{textAlign:'center'}}>{item.title}</div>
                            </li>
                        )
                    }
                </ul>
            </div>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        cateData.map((item, idx) =>
                            <li key = {idx}>
                                <div><img alt="" src={item.img} className='imgcategory'
                                onClick={(e)=> {
                                    mainPhotoRef.current.src = e.target.src}
                                }/></div>
                                <div style={{textAlign:'center'}}>{item.title}</div>
                            </li>
                        )
                    }
                </ul>
            </div>
            {/* 아이콘 클리시  작은 이미지를 가져와서 출력할 메인 이미지*/}
            <div>
                <img alt='' src ='' style={{width:'300px', height:'300px', border:'5px inset gray', margin: '50px 300px'}}
                     ref={mainPhotoRef}/>
            </div>
        </div>
    )
}

export { F_App }