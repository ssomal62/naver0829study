import React, {useState} from "react";
const FiveApp = (props)=> {

    const [msgs, setMsgs] = useState(['Happy', 'Hello', '안녕하세요']);

    return(
        <div>
            <h3 className='alert alert-info'>FiveApp-배열 추가/삭제</h3>
            <input type='text' className='form-control' style={{width: '400px'}} placeholder='메세지입력'

            onKeyUp={(e)=>{
                if(e.key === 'Enter') {
                    setMsgs(msgs.concat(e.target.value))
                }
            }}/>

            <hr/>

            <h6 className='alert alert-sucess'>총 {msgs.length}개의 메세지가 있습니다. (더블클릭 시 삭제)</h6>
            <br/>
            {
                msgs.map((msg, idx)=>(
                    <h6 key={idx} className='select'
                        onDoubleClick={(e)=> {

                        //slice로 삭제
                        // setMsgs([
                        //     ...msgs.slice(0, idx),
                        //     ...msgs.slice(idx + 1, msgs.length)
                        // ])


                        //filter
                        setMsgs(msgs.filter((item, idx2) => idx !== idx2));

                        //
                        }} > {idx + 1} : {msg} </h6>))
            }
        </div>
    )

}
export { FiveApp }