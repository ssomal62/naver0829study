import React, {useState} from "react";
import mem2 from '../images/mem2.png'
const TwoApp=(props)=>{

    //함수형에서 state 변수 선언하는 방법
    const [number, setNumber] = useState(0);

    return (
        <div className="box">
            <h3 className ="alert alert-success">Two App
                <img alt="" src = {mem2} style={{width:'80px', float:'right'}}/>
            </h3>
            <div style={{fontSize: '40px', color :'tan', marginLeft:'200px'}}>
                {/*state 변수 호출*/}
                {number}
            </div>
            <div style={{marginLeft: '117px'}}>
                <button type = 'button' className='btn btn-outline-success'
                        onClick={() => {
                            if(number === 0) {
                                alert("최소 숫자 도달")
                            } else {
                                setNumber(number - 1);
                            }

                        }}
                >숫자 감소</button>
                <span style={{marginLeft:'10px'}}></span>
                <button type = 'button' className='btn btn-outline-success'
                        onClick={() => {

                            if(number === 10) {
                                alert("최대 숫자 도달")
                                return;
                            }

                            setNumber(number + 1);
                        }}
                >숫자 증가</button>
            </div>
        </div>
    );
}

export { TwoApp };