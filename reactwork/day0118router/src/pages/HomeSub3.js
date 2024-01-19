import React from 'react';
import {Alert} from "@mui/material";

const HomeSub2 = () => {
    return (
        <div>
            <Alert variant='filled' severity='warning'>  Sub1 </Alert>
                오시는 길<br/>
                우리회사 심볼3 <br/>
                우리회사 심볼4 <br/>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d42587.94594506067!2d126.98106385153797!3d37.49923735963396!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca17bacfd552f%3A0xb0fb357abc00e8f1!2zSlcg66mU66as7Ja07Yq4IO2YuO2FlCDshJzsmrg!5e0!3m2!1sko!2skr!4v1705562505968!5m2!1sko!2skr" width="600" height="450" style={{border:'0'}} allowFullScreen="" loading="lazy" referrerPolicy="no-referrer-when-downgrade"></iframe>
        </div>
    );
};

export default HomeSub2;
