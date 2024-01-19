import React, {useState} from "react";
import mem3 from '../images/mem3.png'

const ThreeApp = (props) => {

    const inputStyle = {
        marginLeft : '10px'
    }

    const [name, setName]=useState('신영훈');
    const [spring, serSpring]=useState(80);
    const [react, setReact]=useState(77);

    const resultStyle={
        position:'absolute',
        left:'300px',
        top:'100px'
    }

    return (
        <div className='box'>
            <h3 className='alert alert-success'>ThreeApp
            <img alt="" src = {mem3} style={{width:'80px', float:'right'}}/>
            </h3>

            <div style={{width:'200px'}}>
                <div className='input-group'>
                    <h4>이름</h4>
                    <input type = 'text' className='form-control' style={inputStyle} value={name}
                    onChange={(e)=>{
                        setName(e.target.value);
                    }}
                    />
                </div>
                <div className='input-group'>
                    <h4>스프링 점수</h4>
                    <input type = 'text' className='form-control' style={inputStyle} value={spring}
                    onChange={(e)=>{
                        serSpring(Number(e.target.value));
                    }}/>
                </div>
                <div className='input-group'>
                    <h4>리액트 점수</h4>
                    <input type = 'text' className='form-control' style={inputStyle} value={react}
                    onChange={(e) =>{
                        setReact(Number(e.target.value));
                    }}/>
                </div>
                <div style={resultStyle}>
                    이름 : {name}<br />
                    스프링 점수 : {spring}점 <br />
                    리액트 점수 : {react}점 <br />
                    총점 : {spring + react}점 <br />
                    평균 : {(spring + react)/2}점 <br />
                    {/*평균이 90이상은 [장학생], 80 이상은 [우등생], 나머지 [노력]*/}
                    등급 : {(spring+react)/2 >= 90 ? "장학생":"노력"}
                </div>
            </div>
        </div>
    );

}

export { ThreeApp }