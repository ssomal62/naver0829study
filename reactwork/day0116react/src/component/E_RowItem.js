import React from "react";

const E_RowItem = ({row, idx, onDelete}) => {

    return(
        <tr>
            <td>{idx+1}</td>
            <td><img alt="" src = {require(`../images/${row.fphoto}`)} width='70' height='70' hspace='10'/>{row.fname}</td>
            <td valign='middle'>{row.fprice}</td>
            <td valign='middle'>{row.fdate.toLocaleDateString('ko-KR')}</td>
            <td valign='middle'>
                <span style={{curser:'pointer'}} onClick={()=> onDelete(idx)}>🗑️</span> ️
            </td>
        </tr>
    )
}

export default E_RowItem