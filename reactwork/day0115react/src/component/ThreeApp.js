import React from "react";
const ThreeApp = (props)=> {

    const names =['react', 'spring-boot', 'java', 'python', 'vue'];

    const nameList = names.map((element, idx)=>(<li key = {idx}>{element}</li>))

    const imageCount = 10;
    const imagePaths = Array.from({length:imageCount}, (_, i) => `../images/${i+1}.jpg` );

    const ImageGallery = () => (
        <div>
            {imagePaths.map((path, idx) =>( <img alt = "" src={path} key={idx} />))}
        </div>
    )


    return(

        <div>
            <h3 className='alert alert-info'>ThreeApp - Map 반복문</h3>
            {nameList}
            <hr />
        {/*  직접 return 문 안에서 반복해서 출력하는 경우  */}
            {
                names.map((element, idx) => <h6 key={idx}> {idx} : {element}  </h6>)
            }
            <hr />
        {/*  배열이 아닌 특정 숫자 범위로 출력하고자 할 경우  */}
            {
                // [...new Array(10)] // 0~9까지 배열 크기 할당
                // .map((photoNum, idx)=> <img alt="" key={idx} src={require(`../images/${idx+1}.jpg`)} />)
            }


        </div>
    )

}
export { ThreeApp }