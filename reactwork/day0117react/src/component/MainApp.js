import React, {useState} from 'react';
import './MyStyle.css'
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import SixApp from "./SixApp";


const MyComponent = () => {

    const [index, setIndex] = useState(1);

    const onChangeApp = (e) => {
        setIndex(Number(e.target.value));
    }

    return (
        <div style={{margin:'30px'}}>
            <h3 className='alert alert-info'>2024-01-17 리액트 수업 - Axios</h3>
            <label><input type='radio' defaultValue={1} className='myapp' name='myapp' defaultChecked onClick={onChangeApp}/> OneApp </label>
            <label><input type='radio' defaultValue={2} className='myapp' name='myapp' defaultChecked onClick={onChangeApp}/> TwoApp </label>
            <label><input type='radio' defaultValue={3} className='myapp' name='myapp' defaultChecked onClick={onChangeApp}/> ThreeApp </label>
            <label><input type='radio' defaultValue={4} className='myapp' name='myapp' defaultChecked onClick={onChangeApp}/> FourApp </label>
            <label><input type='radio' defaultValue={5} className='myapp' name='myapp' defaultChecked onClick={onChangeApp}/> FiveApp </label>
            <label><input type='radio' defaultValue={6} className='myapp' name='myapp' defaultChecked onClick={onChangeApp}/> SixApp </label>

            <hr />

            {(() => {
                    switch (index) {
                        case 1 : return <OneApp />
                        case 2 : return <TwoApp />
                        case 3 : return <ThreeApp />
                        case 4 : return <FourApp />
                        case 5 : return <FiveApp />
                        case 6 : return <SixApp />
                    }
                })()
            }
        </div>
    );
};

export default MyComponent;
