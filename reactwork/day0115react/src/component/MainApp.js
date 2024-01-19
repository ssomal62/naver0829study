import React, {useState} from 'react';
import './MyStyle.css'
import {OneApp} from "./OneApp";
import {TwoApp} from "./TwoApp";
import {ThreeApp} from "./ThreeApp";
import {FourApp} from "./FourApp";
import {FiveApp} from "./FiveApp";
import {SixApp} from "./SixApp";
import {SevenApp} from "./SevenApp";
import {EightApp} from "./EightApp";

function MainApp(props) {

    const [index, setIndex] = useState(1);

    const onChangeApp = (e) =>{
        setIndex(Number(e.target.value));
    }

    return (
        <div style={{margin:'30px'}}>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={1} defaultChecked  onClick={onChangeApp}/>OneApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={2}  onClick={onChangeApp}/>TwoApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={3}  onClick={onChangeApp}/>Three
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={4}  onClick={onChangeApp}/>FourApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={5}  onClick={onChangeApp}/>FiveApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={6}  onClick={onChangeApp}/>SixApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={7}  onClick={onChangeApp}/>SevenApp
            </label>
            <label>
                <input type='radio' name='myapp' className="myapp" defaultValue={8}  onClick={onChangeApp}/>EightApp
            </label>

            <hr/>
            {
                index === 1 ? <OneApp /> :
                index === 2 ? <TwoApp /> :
                index === 3 ? <ThreeApp /> :
                index === 4 ? <FourApp /> :
                index === 5 ? <FiveApp /> :
                index === 6 ? <SixApp /> :
                index === 7 ? <SevenApp /> :
                    <EightApp />
            }
        </div>
    );
}

export default MainApp;