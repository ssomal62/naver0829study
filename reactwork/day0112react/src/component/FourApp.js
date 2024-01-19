import React, {useState} from "react";
import mem4 from '../images/mem4.png'

const FourApp = ()=> {

    const [fname, setFname] = useState('Noto Sans Kr');
    const [fsize, setFsize] = useState('20px');
    const [fcolor, setFcolor] = useState('tan');

    //글자색 변경 이벤트
    const changeFontColor = (e) => {
        setFcolor(e.target.value);
    }
    const changeFontSize = (e) => {
        setFsize(e.target.value);
    }
    const changeFontName = (e) => {
        setFname(e.target.value);
    }

    return (
        <div className='box'>
            <h3 className='alert alert-danger'>FourApp
            <img alt="" src ={mem4} style={{width:'100px', float:'right'}}/>
            </h3>
            <div style={{fontFamily:fname, fontSize:fsize, color:fcolor}}>
                오늘은 즐거운 금요일!
            </div>
            <div style={{marginTop:'10px'}} onClick={changeFontColor}>
                <label style={{marginRight:'10px'}}><input type='radio' name='fcolor' defaultValue={'black'}  defaultChecked /> 블랙</label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fcolor' defaultValue={'skyblue'}  /> 스카이</label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fcolor' defaultValue={'green'}  />  그린</label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fcolor' defaultValue={'tan'} /> 탄</label>
            </div>
            <div style={{marginTop:'10px'}} onClick={changeFontName} >
                <label style={{marginRight:'10px'}}><input type='radio' name='fname' defaultValue={'Noto Sans Kr'} defaultChecked/> Noto Sans</label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fname' defaultValue={'Black Han Sans'}/> Black Han</label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fname' defaultValue={'Gasoek One'} />  Gasoek On</label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fname' defaultValue={'Gugi'} /> Gugi</label>
            </div>
            <div style={{marginTop:'10px'}} onClick={changeFontSize}>
                <label style={{marginRight:'10px'}}><input type='radio' name='fsize' defaultValue={'13px'} defaultChecked/> + </label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fsize' defaultValue={'20px'}/> ++ </label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fsize' defaultValue={'30px'} /> +++ </label>
                <label style={{marginRight:'10px'}}><input type='radio' name='fsize' defaultValue={'40px'} /> ++++ </label>
            </div>
        </div>
    );

}

export { FourApp }