import React from 'react';
import {Alert} from "@mui/material";
import {useParams} from "react-router-dom";

const Product = () => {

    const {pd1, pd2} = useParams();
    return (
        <div>
            <Alert severity='success' variant='filled'> Product component 입니다.</Alert>

            {
                pd1 == null && pd2 == null &&
                <div>
                    아무 변수 없는 순수 프로덕트입니다.<br />
                    <img src = {require("../images/5.jpg")} style={{width:'300px'}}/>
                </div>
            }
            {
                pd1 != null && pd2 != null &&
                <div>
                    1번 상품을 소개합니다.<br />
                    <img src = {require("../images/15.jpg")} style={{width:'300px'}}/>
                </div>
            }
            {
                pd1 != null && pd2 == null &&
                <div>
                    2번 상품을 소개합니다.<br />
                    <img src = {require("../images/25.jpg")} style={{width:'300px'}}/>
                </div>
            }

        </div>
    );
};

export default Product;
