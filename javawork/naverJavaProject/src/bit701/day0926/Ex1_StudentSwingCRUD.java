package bit701.day0926;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Ex1_StudentSwingCRUD extends JFrame {

    JTextField tfName, tfPhone, tfAge;
    JComboBox<String> cbMBTI;
    JTable table;
    DefaultTableModel tableModel;
    JButton btnAdd, btnDel, btnSearch;

    bit701.dbsetting.DB_Connect db = new bit701.dbsetting.DB_Connect();

    public Ex1_StudentSwingCRUD() {
        super("학 생 관 리");
        this.setBounds(1000,100, 700, 400);
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setDesign();
        this.setVisible(true);

    }

    private void setDesign(){

        tfName = new JTextField(4);
        tfPhone = new JTextField(10);
        tfAge = new JTextField(4);
        String[] cbTitle = {"(선택)","INTP","ISTP","INTJ","ISTJ","ENTP","ESTP","ENTJ","ESTJ"};
        cbMBTI = new JComboBox<String>(cbTitle);

        JPanel pTop = new JPanel();
        pTop.add(new JLabel("이름"));
        pTop.add(tfName);
        pTop.add(new JLabel("나이"));
        pTop.add(tfAge);
        pTop.add(new JLabel("전화"));
        pTop.add(tfPhone);
        pTop.add(new JLabel("MBTI"));
        pTop.add(cbMBTI);

        this.add("North",pTop);

        //하단
        btnAdd = new JButton("추가");
        btnDel = new JButton("삭제");
        btnSearch = new JButton("검색");

        JPanel pButtom = new JPanel();
        pButtom.add(btnAdd);
        pButtom.add(btnDel);
        pButtom.add(btnSearch);

        this.add("South",pButtom);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String age = tfAge.getText();
                String phone = tfPhone.getText();
                String mbti = (String)cbMBTI.getSelectedItem();
                if(name.length() == 0 || phone.length() ==0)
                    return;

                //db에 insert 하는 메서드 호출
                insertStudent(name, age,  phone, mbti);
                //db로부터 다시 데이터를 가져와서 출력
                studentSelsctAll();
                //입력값 쵝화
                tfName.setText("");
                tfPhone.setText("");
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                System.out.println(row);
                if(row == -1){
                    JOptionPane.showMessageDialog(Ex1_StudentSwingCRUD.this,"삭제할 행을 선택해주세요");
                }else{
                    String num = table.getValueAt(row,0).toString();
                    deleteStudent(num);
                    studentSelsctAll();
                }
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //검색할 이름 입력받기
                String searchName = JOptionPane.showInputDialog("검색할 이름을 입력해주세요.");
                System.out.println(searchName);
                if(searchName==null)
                    return;
                else{
                    searchStudent(searchName);
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentSelsctAll();
            }
        });




        String[] title = {"번호","이름","나이", "MBTI","전화번호","작성일"};
        tableModel = new DefaultTableModel(title,0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));

        //초기 db 데이터 가져오기
        studentSelsctAll();

    }

    private void searchStudent(String searchName) {

        //기존 테이블의 데이터를 모두 지운다.
        tableModel.setRowCount(0);

        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from student WHERE NAME like ? order by ID desc";

        try{
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,"%" + searchName + "%");
            rs = pstmt.executeQuery();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next()){

                Vector<String> data = new Vector<>();
                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                String age = rs.getString("AGE");
                String phone = rs.getString("PHONE_NUMBER");
                String mbti = rs.getString("MBTI");
                Timestamp ts = rs.getTimestamp("DATE_OF_CREATION");

                String currentDate = sdf.format(ts);

                data.add(id);
                data.add(name);
                data.add(age);
                data.add(mbti);
                data.add(phone);
                data.add(currentDate);

                tableModel.addRow(data);


            }


        }catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.DbClose(rs,pstmt,connection);
        }

    }

    public static void main(String[] args) {
        Ex1_StudentSwingCRUD ex = new Ex1_StudentSwingCRUD();

    }

    public void studentSelsctAll(){

        //기존 테이블의 데이터를 모두 지운다.
        tableModel.setRowCount(0);

        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from student order by ID desc";

        try{
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next()){

                Vector<String> data = new Vector<>();
                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                String age = rs.getString("AGE");
                String phone = rs.getString("PHONE_NUMBER");
                String mbti = rs.getString("MBTI");
                Timestamp ts = rs.getTimestamp("DATE_OF_CREATION");

                String currentDate = sdf.format(ts);

                data.add(id);
                data.add(name);
                data.add(age);
                data.add(mbti);
                data.add(phone);
                data.add(currentDate);

                tableModel.addRow(data);


            }


        }catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.DbClose(rs,pstmt,connection);
        }


    }

    public void insertStudent(String name, String age, String phone, String mbti){
        //출력 된 거 확인하고 주석처리하기
//        System.out.println(name);
//        System.out.println(age);
//        System.out.println(phone);
//        System.out.println(mbti);


        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into student values (null,?,?,?,?,now())";

        try{
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, age);
            pstmt.setString(3, phone);
            pstmt.setString(4, mbti);

            pstmt.execute();

        }
        catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.DbClose(pstmt,connection);
        }
    }


    //db 삭제하는 메서드
    public void deleteStudent(String num){
//        System.out.println(num);

        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;

        String sql = "delete from student where ID = ? ";

        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,num);
            pstmt.execute();
        }
        catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.DbClose(pstmt,connection);
        }



    }

}
