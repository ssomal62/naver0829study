package bit701.day0918;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ex2_Table2 extends JFrame{
    JTable table1, table2;
    public Ex2_Table2 (String title){
        super(title);
        this.setBounds(400,100, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//자동으로 프레임을 종료해주는 메서드
        this.setDesign();
        this.setVisible(true);
    }


    public void setDesign(){

        this.setLayout(new GridLayout(2,1));
//        table1 = new JTable(5,4);  //5행 4열의 빈테이블이 만들어진다.
//        this.add(table1);

        DefaultTableModel model = new DefaultTableModel(new String[] {"이름","나이","주소"},3);
        table1 = new JTable(model);
        this.add(new JScrollPane(table1));//스크롤이 가능하도록 만들어줘야 제목도 나온다.

        //table2에는 데이터를 넣어보자.
        String[][] data = {
                {"강부자","56","강남구"},
                {"이순재", "67", "여의도"},
                {"신규","56","제주도"}
        };

        table2 = new JTable(data, new String[] {"이름", "나이","주소"});
        this.add(new JScrollPane(table2));


    }


    public static void main(String[] args){
        Ex2_Table2 ex = new Ex2_Table2("제이테이블");
    }

}
