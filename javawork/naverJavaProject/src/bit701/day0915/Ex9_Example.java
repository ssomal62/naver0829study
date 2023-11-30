package bit701.day0915;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex9_Example extends JFrame {
    MyCanvas myCanvas;
JButton button1, button2, button3, button4;

String initImage1 = "C:\\Users\\wxy89\\OneDrive\\문서\\bitcamp\\naverCloud\\img\\연예인사진2\\";
String initImage2 = "";
String initImage3 = "C:/Users/wxy89/OneDrive/바탕 화면/질럿.jpg";
String initImage4 = "C:\\Users\\wxy89\\OneDrive\\사진\\FilmCamera\\000000020012230815.jpg";

//C:\Users\wxy89\OneDrive\사진\Pictures\KakaoTalk_20220908_012522704.jpg
    public Ex9_Example(String title){
        super(title);
        this.setLocation(600,200);
        this.setSize(700,700);

        this.setDesign();

        this.setVisible(true);

        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });

    }



    public static void main(String[] args) {
        Ex9_Example ex = new Ex9_Example("예제");
    }



    private void setDesign(){
        this.add(myCanvas,"Center");

        button1 = new JButton("연예인사진");
        button2 = new JButton("귤");
        button3 = new JButton("프로토스");
        button4 = new JButton("나");




        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        this.add(panel,"North");

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myCanvas.repaint();
            }

        });




    }

    class MyCanvas extends Canvas{

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Image image1 = new ImageIcon(initImage2).getImage();
            g.drawImage(image1 ,70,10,370,450,this);
        }
    }


}




