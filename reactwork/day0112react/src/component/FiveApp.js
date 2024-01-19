import React, {useState} from "react";
import mem5 from '../images/mem5.png'
import s1 from '../images/1.jpg'
import s2 from '../images/2.jpg'
import s3 from '../images/3.jpg'
import s4 from '../images/4.jpg'
import s5 from '../images/5.jpg'
const FiveApp = ()=> {

    const [show, setShow]=useState(true);
    const [photo, setPhoto]=useState(s1);
    const [border, setBorder]=useState('solid');
    return (
        <div className='box'>
            <h3 className='alert alert-info'>FiveApp
                <img alt="" src={mem5} style={{width:'100px', float:'right'}} />
            </h3>
            <div>
                <label>
                    <input type='checkbox' defaultChecked
                    onClick={(e)=>{
                        setShow(e.target.checked);
                    }}/>
                    체크박스!
                </label>

                <select className='form-select' style={{width:'200px'}}
                onChange={(e)=>{
                setPhoto(e.target.value)}}>
                    <option value={s1}>커튼</option>
                    <option value={s2}>스크런치</option>
                    <option value={s3}>런치백</option>
                    <option value={s4}>블레이저</option>
                    <option value={s5}>플랫슈즈</option>
                </select>

                <select className='form-select' style={{width:'200px'}}
                onChange={(e)=>{
                    setBorder(e.target.value)
                }}>
                    <option>solid</option>
                    <option>inset</option>
                    <option>dotted</option>
                    <option>double</option>
                    <option>dashed</option>
                </select>
                <br/><br/>
                {
                    //show 값이 true이면 이미지가 보이고, false면 안보인다
                    show&&
                    <img alt="" src={photo} style={{width:'300px', border:`5px ${border} gray`}}/>
                }
            </div>
        </div>
    );
}

export {FiveApp}