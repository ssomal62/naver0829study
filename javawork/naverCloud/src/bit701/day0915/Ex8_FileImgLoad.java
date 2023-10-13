package bit701.day0915;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex8_FileImgLoad extends JFrame {
    JButton btnImageFile;
    String  initImage = "C:/Users/wxy89/OneDrive/바탕 화면/질럿.jpg";
    Image image;
    MyCanvas myCanvas = new MyCanvas();


    public Ex8_FileImgLoad (String title){
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

    //캔버스 내부 클래스

    class  MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {//처음 시작 시 자동호출 되고, 프레임 크기 변경 시에도 자동호출. 그 외에는 자동 호출 안됨.
            super.paint(g);
            g.drawImage(image, 70,10,370, 450, this);

        }
    }

    private  void setDesign(){ //외부에서 호출할 일이 없기 때문에 굳이 public으로 변경 안함.

        JPanel panel = new JPanel();
        btnImageFile = new JButton("이미지 파일 가져오기");
        panel.add(btnImageFile);
        this.add("North",panel);

        //사진을 Image로 변환
        image = new ImageIcon(initImage).getImage();
        this.add("Center",myCanvas);

        //파일 버튼 이벤트
        btnImageFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(Ex8_FileImgLoad.this,"이미지열기",FileDialog.LOAD);
                dlg.setVisible(true);

                if(dlg.getDirectory() == null){
                    return;
                }
                initImage = dlg.getDirectory()+dlg.getFile();
                image = new ImageIcon(initImage).getImage();


                //캔버스의 paint 메서드는 버튼을 누른다고 자동호출되지 않는다.
                //강제로 호출을 해줘야한다.
                myCanvas.repaint();

            }
        });


    }

    public static void main(String[] args) {
        Ex8_FileImgLoad  s = new Ex8_FileImgLoad ("이미지뷰어");
    }


}
