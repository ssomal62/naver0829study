import React, {useState, useEffect} from "react";
const OneApp = (props)=> {

    const [count, setCount] = useState(0);
    const [number, setNumber] = useState(0);
    const [message, setMessage] = useState('inputMessage');

    //count만 증가하는 이벤트

    const increCount= () => {
        setCount(count + 1);
    }

    const increNumber= () => {
        setNumber(number + 1);
    }

    const increCountNumber= () => {
        setCount(count + 1);
        setNumber(number + 1);
    }

    // useEffect(() => {
    //     return () => {
    //         console.log('useEffect 호출됨!!')
    //     };
    // });

    useEffect(() => {
        return () => {
            console.log('count 변경!')
        };
    },[count]);

    useEffect(() => {
        return () => {
            console.log('number 변경!')
        };
    },[number]);


    return(
        <div>
            <h3 className='alert alert-info'>OneApp</h3>
            <button type='button' className='btn btn-outline-secondary' onClick={increCount}>
                count만 증가
            </button>
            <button type='button' className='btn btn-outline-secondary' onClick={increNumber}>
                number만 증가
            </button>
            <button type='button' className='btn btn-outline-secondary' onClick={increCountNumber}>
                count, number 모두 증가
            </button>
            <br />
            <input type='text' value={message} onChange={(e)=> {
                setMessage(e.target.value)}} /> <br/>
            <b style={{fontSize:'2em'}}> Count : {count} </b><br/>
            <b style={{fontSize:'2em'}}> Number : {number} </b><br/>
            <b style={{fontSize:'20px'}}> {message} </b><br/>
        </div>
    );

}
export { OneApp }