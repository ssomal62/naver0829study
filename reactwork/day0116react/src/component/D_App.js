import React, {useState} from "react";
import D_Child_App from './D_Child_App'

const D_App = (props) => {

    const [count, setCount] =useState(0);

    const changeCount = ()=> {
        setCount(count + 1)
    }

    return(
        <div>
            <h3 className='alert alert-danger'>D : 부모, 자식간 통신</h3>

            <h4>방문 횟수 : {count}회</h4> {/*자식앱에서 변경할 항목 생성 */}
            <D_Child_App name={'캔디'} age={23} addr={'제주도'} incre={changeCount}/>
            <D_Child_App name={'안쏘니'} age={28} addr={'LA'} incre={changeCount}/>
            <D_Child_App name={'테리우스'} age={35} addr={'하와이'} incre={changeCount}/>
        </div>
    )
}

export { D_App }