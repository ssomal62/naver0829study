package bit701.day0915;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex6_FileMemoFrame extends JFrame {
    JTextArea memoArea;
    JButton btnSave,btnOpen,btnClear;
    public Ex6_FileMemoFrame (String title){
        super(title); //JFrame의 문자열을 받는 생성자 호출.
        this.setLocation(300,100);//프레임 시작 위치
        this.setSize(300,300);//프레임의 너비, 높이
        this.getContentPane().setBackground(Color.CYAN);

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


        btnSave = new JButton("파일 저장");
        btnOpen = new JButton("파일 열기");
        btnClear = new JButton("내용 지우기");

        JPanel panel = new JPanel();
        panel.add(btnSave);
        panel.add(btnOpen);
        panel.add(btnClear);

        this.add(panel,"North");

        memoArea = new JTextArea("내용을 입력해주세요.");
        //this.add(memoArea,"Center");//데이터가 길 경우 스크롤바가 안생김

        this.add(new JScrollPane(memoArea),"Center");

        //버튼 : 내용 지우기
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoArea.setText("");
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(Ex6_FileMemoFrame.this,"메모장 저장",FileDialog.SAVE);
                dlg.setVisible(true);
                //System.out.println("디렉토리 : " + dlg.getDirectory());
                //System.out.println("파일명 : " + dlg.getFile());

                //취소시 메서드 종료
                if(dlg.getDirectory() == null)
                    return;
                String fileName = dlg.getDirectory() + dlg.getFile() + ".txt";
                String memoText = memoArea.getText();

                FileWriter fw = null;
                try{
                    fw = new FileWriter(fileName);
                    fw.write(memoText);
                    memoArea.setText("저장되었습니다.");
                }catch (IOException el){
                    el.printStackTrace();
                }finally {
                    try{
                        fw.close();
                    }catch (NullPointerException | IOException e1){
                        e1.printStackTrace();
                        System.out.println("메모장 저장 시 오류가 발행하였습니다.");
                    }
                }
            }
        });

        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(Ex6_FileMemoFrame.this,"메모장 열기",FileDialog.LOAD);
                dlg.setVisible(true);

                if(dlg.getDirectory() == null)
                    return;

                String fileName = dlg.getDirectory() + dlg.getFile();

                FileReader fr = null;
                BufferedReader br = null;

                try{

                    fr = new FileReader(fileName);
                    br = new BufferedReader(fr);
                    //메모장의 기존 내용 지우기
                    memoArea.setText("");

                    while(true){
                        String line = br.readLine();
                        if(line == null) break;

                        memoArea.append(line + "\n");
                    }
                }catch (IOException e1){
                    e1.printStackTrace();
                }finally {
                    try{
                        br.close();
                        fr.close();
                    }catch (IOException |NullPointerException e1){
                            e1.printStackTrace();
                    }
                }
             ;




            }
        });

    }



    public static void main(String[] args) {

        Ex6_FileMemoFrame  s = new Ex6_FileMemoFrame ("간단한 메모장");

    }
}
