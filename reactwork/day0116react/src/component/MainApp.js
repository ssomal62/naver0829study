import React, {useState} from "react";
import {A_App} from "./A_App";
import {B_App} from "./B_App";
import {C_App} from "./C_App";
import {D_App} from "./D_App";
import {E_App} from "./E_App";
import {F_App} from "./F_App";
import './MyStyle.css'
function MainApp(props) {

    const [index, setIndex] = useState(1);

    const onChangeApp = (e) => {
        setIndex(Number(e.target.value));
    }

    return (<div style={{margin: '30px'}}>
            <h3 className='alert alert-success'>2024-01-16 리액트 수업</h3>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={1} defaultChecked
                       onClick={onChangeApp}/>OneApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={2} onClick={onChangeApp}/>TwoApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={3} onClick={onChangeApp}/>Three
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={4} onClick={onChangeApp}/>FourApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={5} onClick={onChangeApp}/>FiveApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={6} onClick={onChangeApp}/>SixApp
            </label>

            <hr/>
            {
                index === 1 ? <A_App/> :
                index === 2 ? <B_App/> :
                index === 3 ? <C_App/> :
                index === 4 ? <D_App/> :
                index === 5 ? <E_App/> :
                    <F_App/>
            }
        </div>);
}

export default MainApp;