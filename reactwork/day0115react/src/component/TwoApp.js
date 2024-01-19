import React, {useEffect, useState} from "react";
import img01 from '../images/3.jpg'
import img02 from '../images/25.jpg'
const TwoApp = (props)=> {

    const [show, setShow] = useState(true);
    const [count, setCount] = useState(1);

    const addCount= ()=> {
        setCount(Number(count + 1))
    }

    useEffect(() => {
        setShow(count % 3 === 0)
    }, [count]);

    return(
        <div>
            <h3 className='alert alert-info'>TwoApp - 3의 배수마다 이미지 보이기/안보이기</h3>
            <button type='button' className='btn btn-outline-secondary' onClick={addCount}>숫자 증가</button>
            <b style={{fontSize:'4em', color:'tan', marginLeft:'50px'}}>{count}</b>
            <br/>
            <br/>
            {
                show &&
                <img alt="" src={img01} />
            }
            {
                !show &&
                <img alt="" src={img02} />
            }

        {/*src의 이미지를 import 없이 출력하기 */}
            <img alt='' src = {require('../images/25.jpg')} />
        </div>
    )

}
export { TwoApp }