import React from "react";
import img1 from '../images/4.jpg'
import img2 from '../images/10.jpg'
import img3 from '../images/25.jpg'
import img4 from '../images/20.jpg'
import './MyStyle.css'
const FourApp = (props)=> {

    const myImage = [img1, img2, img3, img4]

    const data = [
        {"name" : "자몽", "addr" : "서울", "hp" : "010-1111-1111", "photo":"11"},
        {"name" : "핕치", "addr" : "광주", "hp" : "010-2222-2222", "photo":"9"},
        {"name" : "공룡", "addr" : "부산", "hp" : "010-3333-3333", "photo":"7"},
        {"name" : "리아", "addr" : "여수", "hp" : "010-4444-4444", "photo":"5"}
    ]

    return(
        <div>
            <h3 className='alert alert-info'>Four App</h3>
            {
                myImage.map((img, idx)=>(
                    <img alt="" src = {img} width = '200px'  />
                ))
            }
            <hr />
            {
                data.map((element, idx) => (
                    <div className='box' key={idx}>
                        <h5>이름 : {element.name}</h5>
                        <h5>주소 : {element.addr}</h5>
                        <h5>HP : {element.hp}</h5>
                        <img alt="" src = {require(`../images/${element.photo}.jpg`)} width='120px'/>
                    </div>
                ))
            }

        <hr style={{clear: 'both'}} />
        <table>
            <thead>
            <tr>
                <th>이름</th>
                <th>주소</th>
                <th>HP</th>
                <th>Photo</th>
            </tr>
            </thead>
            <tbody>
            {/*반복이 필요한 부분에 중괄호를 열고 선언한다. */}
            {
                data.map((element, idx) => (
                <tr key={idx}>
                    <td>{element.name}</td>
                    <td>{element.addr}</td>
                    <td>{element.hp}</td>
                    <td><img alt="" src = {require(`../images/${element.photo}.jpg`)} width='120px'/></td>
                </tr>
                ))
            }
            </tbody>
        </table>


        </div>
    )

}
export { FourApp }