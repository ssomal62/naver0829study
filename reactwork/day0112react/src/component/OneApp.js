//초기 리액트는 컴포넌트가 클래스로 구현되어있다.

import React, {Component} from "react";
import './MyStyle.css'
import mem1 from '../images/mem1.png'
import s10 from '../images/2.jpg'
class OneApp extends React.Component {

    //class에서 변경가능한 state 변수 선언하는 방법

    //js는 생성자 선언법이 모두 동일
    //ES6에서 생성자 선언하는 방법
    constructor() {
        super();  //필수 (생략불가)
        this.state = {
            number:0
        }
    }
    render() {
        //style 을 변수로 지정한 후 적용하는 방법
        const imgStyle = {
            border : '2px solid gray',
            width : '130px'
        }

        const fontStyle = {
            color : 'green',
            fontWeight : '800'
        }

        //변경이 필요없는 메세지 변수 선언
        const message = "Have a Good Day!"


        return (
            <div className="box">
                <h3 className="alert alert-info">OneApp
                    <img alt="" src={mem1} style={{width:'80px', float:'right'}} />
                </h3>


                <img alt="" src ={s10} style={imgStyle}/>

                <h2 style={fontStyle}>{message}</h2>

                <div style={{fontSize:'40px', color:'tan', marginLeft:'30px'}}>
                    {/* class일 경우 state 변수 출력하는 방법*/}
                    {this.state.number}
                </div>

                <button type='button' className="btn btn-outline-danger"
                onClick={() => {
                    //number 값 1씩 증가
                    this.setState({
                        number: this.state.number + 1
                        })
                }}>number 증가</button>
            </div>
        )
    }
}


//export 방법 1
//현재 파일 내 컴포넌트가 여러개가 있을 수 있음
//default는 export선언은 단 한번만 가능.
//import를 할 때 이름을 지정할 수 있음.
//export default OneApp;

//export 방법 2
//여러번 export 가능
//import  가능. import시에 '{OneApp}'으로 고정. 이름 변경 불가.
export { OneApp }
