package bit701.day0915;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex3_SwingButton extends JFrame implements ActionListener {

    JButton button1, button2;

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            System.out.println("버튼1 클릭");
            this.getContentPane().setBackground(Color.CYAN);
        }else{
            System.out.println("버튼2 클릭");
            this.getContentPane().setBackground(Color.GREEN);
        }

    }

    public Ex3_SwingButton(String title){
        super(title); //JFrame의 문자열을 받는 생성자 호출.
        this.setLocation(300,100);//프레임 시작 위치
        this.setSize(300,300);//프레임의 너비, 높이
        //this.getContentPane().setBackground(Color.GREEN);

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

    private  void setDesign(){ //외부에서 호출할 일이 없기 때문에 굳이 public으로 변경 안함.

        button1 = new JButton("버튼 #1");
        this.add(button1,"South"); //BorderLayout [기본] 인 경우는 위치를 지정해야함, North, South, East, West,
        button2 = new JButton("버튼 #2");
        this.add(button2,"North");

        button1.addActionListener(this);//() this는 이벤트 메서드가 구현된 클래스의 인스턴스
        button2.addActionListener(this);//둘다 같은 이벤트 메서드가 호출된다.
    }

    public static void main(String[] args) {

        Ex3_SwingButton s = new Ex3_SwingButton("버튼");

    }


}
