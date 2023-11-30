package bit701.day0915;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex4_SwingButton extends JFrame {
    JButton button1, button2, button3;;
    public Ex4_SwingButton(String title){
        super(title); //JFrame의 문자열을 받는 생성자 호출.
        this.setLocation(300,100);//프레임 시작 위치
        this.setSize(300,300);//프레임의 너비, 높이
        this.getContentPane().setBackground(Color.GREEN);

        //디자인이나 이벤트를 구현할 메서드 호출
        this.setDesign();


        this.setVisible(true);//true : 프레임을 보이게하기,  false :  프레임숨기기

        //윈도우 이벤트  발생 = 익명 내부클래스 형태고 이벤트 구현
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                //JOptionPane.showMessageDialog(SwingBasic.this,"프레임을 종료합니다.");

                //실제 종료
                System.exit(0);//정상적으로 종료시 0을 넣어주면 (일반적으로 0을 보냄)
                super.windowClosing(e);

            }
        });

    }



    //버튼 이벤트를 이번에는 내부 클래스로 만들어보자

    class MyColorButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==button1){
                Ex4_SwingButton.this.getContentPane().setBackground(Color.ORANGE);
            }else{
                Ex4_SwingButton.this.getContentPane().setBackground(Color.PINK);
            }

        }
    }
    private  void setDesign(){ //외부에서 호출할 일이 없기 때문에 굳이 public으로 변경 안함.
        //w자바에서 제공하는 레이아웃을 안스고 직접 위치 지정을 하는 경우
        this.setLayout(null);

        //버튼1 생성
        button1 = new JButton("오렌지색");
        button1.setBounds(20,50,100,50);
        this.add(button1);

        button2 = new JButton("분홍색");
        button2.setBounds(150,50,100,50);
        this.add(button2);

        //버튼 1,2는 내부 클래스 MyColorButton 이벤트를 호출해보자.
        button1.addActionListener(new MyColorButton());
        button2.addActionListener(new MyColorButton());

        button3 = new JButton("버튼3");
        button3.setBounds(20,120,130,50);
        this.add(button3);

        //버튼3은 익명내부클래스 형태로 만들어보기
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setBackground(Color.WHITE);
                button1.setForeground(Color.LIGHT_GRAY);

                button2.setBackground(Color.PINK);
                button2.setForeground(Color.LIGHT_GRAY);

                button3.setBackground(Color.magenta);
                button3.setForeground(Color.yellow);

            }
        });
    }

    public static void main(String[] args) {

        Ex4_SwingButton s = new Ex4_SwingButton("이벤트 연습");


    }
}
