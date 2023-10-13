package bit701.day0915;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EX7_Canvas extends JFrame  {
    MyCanvas myCanvas = new MyCanvas();
    String imageIcon1  = "C:/Users/wxy89/OneDrive/바탕 화면/질럿.jpg";

    public EX7_Canvas(String title){
        super(title); //JFrame의 문자열을 받는 생성자 호출.
        this.setLocation(300,100);//프레임 시작 위치
        this.setSize(500,500);//프레임의 너비, 높이
        this.getContentPane().setBackground(Color.pink);

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
// 캔버스 내부 클래스
    class MyCanvas extends Canvas{
    @Override
    public void paint(Graphics g) {//Graphics >> 도구상자
        super.paint(g);
        //원그리기
        g.setColor(new Color(255,100,255));//선 색
        g.drawOval(50,50,100,100);//테두리선만 있는 원
        g.fillOval(200,50,100,100);

        Image image1 = new ImageIcon(imageIcon1).getImage();
        g.drawImage(image1,300,30,100,100,this);

    }
}

    private  void setDesign(){ //외부에서 호출할 일이 없기 때문에 굳이 public으로 변경 안함.
        this.add(myCanvas,"Center");
        //상단에는 패널 안에 버튼 추가 후 프레임에 패널 추가


    }

    public static void main(String[] args) {

        EX7_Canvas s = new EX7_Canvas("안녕");

    }
}
