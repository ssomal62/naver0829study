package bit701.day0919;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class Ex4_ClientChat extends JFrame implements Runnable{
    String nickName;
    JTextArea area;
    JTextField tfNickName,tfMessage,tfServerIp;
    JButton btnSend,btnConnect;
    Socket clientSocket;

    public Ex4_ClientChat() {
        // TODO Auto-generated constructor stub
        this.setBounds(1000, 100, 400, 400);
        this.setDesign();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        //System.out.println("호출");

        //서버에 접속
        try {
            clientSocket=new Socket(tfServerIp.getText(), 6000);
            area.append("서버에 접속 성공!!\n");
        } catch (IOException e) {
            area.append("서버에 접속 실패:"+e.getMessage()+"\n");
        }

    }

    private void setDesign() {
        // TODO Auto-generated method stub
        JPanel pTop=new JPanel();
        tfNickName=new JTextField("Aiur",5);//자기이름으로 초기값
        tfServerIp=new JTextField("192.168.0.29");//각자 자기 ip를 초기값으로

        btnConnect=new JButton("서버접속");
        pTop.add(new JLabel("닉네임:"));
        pTop.add(tfNickName);
        pTop.add(tfServerIp);
        pTop.add(btnConnect);
        this.add("North",pTop);

        JPanel pBottom=new JPanel();
        tfMessage=new JTextField(25);
        btnSend=new JButton("전송");
        pBottom.add(tfMessage);
        pBottom.add(btnSend);
        this.add("South",pBottom);

        area=new JTextArea();
        this.add("Center",new JScrollPane(area));

        //접속 버튼
        btnConnect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //닉네임을 읽어서 창제목으로 넣기
                nickName=tfNickName.getText();
                //창제목으로 넣기
                Ex4_ClientChat.this.setTitle(nickName+"님 채팅창");

                //run 메소드 호출
                Thread th=new Thread(Ex4_ClientChat.this);
                th.start();//run 메소드 호출
            }
        });

    }

    public void autoScroll()
    {
        int n=area.getDocument().getLength();//총 라인수
        area.setCaretPosition(n);//마지막줄로 위치 변경
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Ex4_ClientChat client=new Ex4_ClientChat();

    }

}