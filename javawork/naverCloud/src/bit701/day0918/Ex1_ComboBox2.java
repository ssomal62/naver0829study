package bit701.day0918;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class Ex1_ComboBox2 extends JFrame {
    JPanel p = new JPanel();
    JComboBox<String> combo;
    JRadioButton rbYellow, rbMagenta, rbGray, rbBlue;
    JLabel lblMessage;
    public Ex1_ComboBox2(String title){
        super(title);
        this.setBounds(400,100, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//자동으로 프레임을 종료해주는 메서드
        this.setDesign();
        this.setVisible(true);
    }

    private void setDesign(){

        Vector<String> list = new Vector<String>();
        list.add("빨강");
        list.add("초록");
        list.add("분홍");
        list.add("오렌지");

        //콤보박스 생성
        combo = new JComboBox<String>(list);
        //상단에 추가

        JPanel pTop = new JPanel();
        this.add("North", new JPanel());
        pTop.add(combo);//?
        this.add("North",pTop);//?

        //p패널에 라벨 추가
        lblMessage = new JLabel("Have a Nice Day!!");
        p.add(lblMessage);

        //센터에 J패널 p추가
        p.setBackground(Color.red);
        this.add("Center",p);

        combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectColor = (String) combo.getSelectedItem();
                //System.out.println(selectColor);
                //jdk 8부터 switch에서 String도 가능

                switch(selectColor){
                    case "빨강":
                        p.setBackground(Color.red);
                        break;
                    case "분홍":
                        p.setBackground(Color.pink);
                        break;
                    case "오렌지":
                        p.setBackground(Color.orange);
                        break;
                    case "초록":
                        p.setBackground(Color.green);
                        break;
                }

            }
        });
        
        //하단의 4개의 라디오 버튼 추가하기
        ButtonGroup bg = new ButtonGroup();
        rbYellow = new JRadioButton("노랑");
        rbBlue = new JRadioButton("파랑");
        rbGray = new JRadioButton("회색");
        rbMagenta = new JRadioButton("마젠타");

        bg.add(rbYellow);
        bg.add(rbBlue);
        bg.add(rbGray);
        bg.add(rbMagenta);

        JPanel pBotton = new JPanel();
        pBotton.add(rbYellow);
        pBotton.add(rbBlue);
        pBotton.add(rbGray);
        pBotton.add(rbMagenta);

        this.add("South",pBotton);

        rbYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMessage.setForeground(Color.yellow);
            }
        });
        rbBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMessage.setForeground(Color.blue);
            }
        });
        rbGray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMessage.setForeground(Color.gray);
            }
        });
        rbMagenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMessage.setForeground(Color.magenta);
            }
        });

    }

    public static void main(String[] args){
        Ex1_ComboBox2 ex = new Ex1_ComboBox2("ComboBox");
    }

}
