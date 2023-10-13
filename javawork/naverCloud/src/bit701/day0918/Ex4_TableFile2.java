package bit701.day0918;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Ex4_TableFile2 extends JFrame {
    JTable table;
    DefaultTableModel model;
    JTextField tfName, tfAge, tfAddr;
    JButton btnAdd;
    //파일이름
    final static String FILENAME = "C:/Temp/member.txt";
    public Ex4_TableFile2 (String title){
        super(title); //JFrame의 문자열을 받는 생성자 호출.

        this.setLocation(300,100);//프레임 시작 위치
        this.setSize(400,300);//프레임의 너비, 높이

        //디자인이나 이벤트를 구현할 메서드 호출
        this.setDesign();

        this.setVisible(true);//true : 프레임을 보이게하기,  false :  프레임숨기기

        //윈도우 이벤트  발생 = 익명 내부클래스 형태고 이벤트 구현
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                //JOptionPane.showMessageDialog(SwingBasic.this,"프레임을 종료합니다.");
                FileWriter fw = null;
                try{
                    fw = new FileWriter(FILENAME,true);

                    int row = table.getRowCount();
                    for(int i = 0; i< row; i++){
                        String name = (String)model.getValueAt(i,0);
                        String age = (String) model.getValueAt(i,0);
                        String addr =(String)model.getValueAt(i,0);

                    }
                }catch (IOException e1){
                    e1.printStackTrace();

                }finally {
                    try{
                        fw.close();
                    }catch(IOException e1){
                        e1.printStackTrace();

                    }

                }


                //실제 종료
                System.exit(0);//정상적으로 종료시 0을 넣어주면 (일반적으로 0을 보냄)
                super.windowClosing(e);
            }
        });
    }

    private  void setDesign(){ //외부에서 호출할 일이 없기 때문에 굳이 public으로 변경 안함.
        JPanel p = new JPanel();
        tfName = new JTextField(4);
        tfAge = new JTextField(3);
        tfAddr = new JTextField(5);
        btnAdd = new JButton("추가");
        p.add(new JLabel("이름"));
        p.add(tfName);
        p.add(new JLabel("나이"));
        p.add(tfAge);
        p.add(new JLabel("주소"));
        p.add(tfAddr);

        this.add("North",p);

        model = new DefaultTableModel(new String[]{"이름","나이","주소"},0);
        table = new JTable(model);
        this.add("Center", new JScrollPane(table));

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1.입력값을 Vector에 넣는다.
                Vector<String> data = new Vector<String>();
                data.add(tfName.getText());
                data.add(tfAge.getText());
                data.add(tfAddr.getText());

                //2.addRow 메서드로 행을 추가한다.
                model.addRow(data);

                //3.입력한 값들을 지운다.
                tfName.setText("");
                tfAge.setText("");
                tfAddr.setText("");

            }
        });

    }

    public static void main(String[] args) {
        Ex4_TableFile2 ex = new Ex4_TableFile2("안녕");
    }
}
