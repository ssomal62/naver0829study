package bit701.day0918;

import javax.swing.*;

public class Ex0_Sample2 extends JFrame {

    public Ex0_Sample2(String title){
        super(title);
        this.setBounds(400,100, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//자동으로 프레임을 종료해주는 메서드
        this.setVisible(true);
    }
    public static void main(String[] args){
        Ex0_Sample2 ex = new Ex0_Sample2("ComboBox");
    }

}
