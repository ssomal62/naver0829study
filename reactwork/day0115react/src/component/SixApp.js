import React, {useState} from "react";

const SixApp = (props)=> {
    const [photo, setPhoto] = useState(['1','2']);
    const [num, setNum] = useState('');

    // const pressEnter = (e) => {
    //     if (e.key === 'Enter'){
    //         //배열 photo에  num 값 추가
    //         setPhoto(photo.concat(e.target.value))
    //         //num값 초기화
    //         setNum('');
    //     }
    // }
    //
    // const checkNumber = (e) => {
    //     if (!(0 < e.target.value && e.target.value < 16)) {
    //         alert('잘못됩 값입니다.')
    //     }
    // }
    //
    // useEffect(() => {
    //     return () => {
    //         checkNumber();
    //     };
    // }, [pressEnter]);

    return (
        <div>
            <h3 className='alert alert-info'>SixApp - 문제</h3>

            <input type='text' placeholder='이미지번호 입력 후 엔터' className='form-control' style={{width:'300px'}} value={num}
            onChange={(e) => setNum(e.target.value)}
            onKeyUp={
                (e)=>{

                if (e.key === 'Enter'){
                    if (!(0 < e.target.value && e.target.value < 16)) {
                        alert('잘못됩 값입니다.')
                        return;
                    }

                    //배열 photo에  num 값 추가
                     setPhoto(photo.concat(e.target.value))
                    //num값 초기화
                     setNum('');
            }}
            }
            />
        {/*     1~15 사이 번호 입력 후 엔터를 누르면 해당 자동차 이미지로 출력
           해당 자동차 이미지에서 더블클릭하면 자동차 삭제하기 */}

        {
            photo.map((item, idx) => (
            <img alt="" src = {require(`../images/${item}.jpg`)} width='120px'
            onDoubleClick={(e)=>{
                setPhoto(photo.filter((item2, idx2) => idx !== idx2));
            }}
            />))

        }
        </div>
    )
}
export { SixApp }