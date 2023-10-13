package bit701.day0926;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Ex2_productsSwingCRUD extends JFrame{

    JTextField pCode, pName, pScale, pBuyprice;
    JComboBox<String> pLine;
    JTable table;
    DefaultTableModel tableModel;
    JButton btnAll, btnAdd, btnDel, btnSearch;

    bit701.dbsetting.DB_Connect db = new bit701.dbsetting.DB_Connect();;

    public Ex2_productsSwingCRUD() {
        super("Products");

        this.setBounds(1000,100,1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDesign();
        this.setVisible(true);
    }

    private void setDesign() {
        pCode = new JTextField(5);
        pName = new JTextField(20);
        String[] lineTitle = {"(선택)", "Classic Cars","Motorcycles","Planes","Ships", "Trains","Trucks and Buses", "Vintage Cars" };
        pLine = new JComboBox<>(lineTitle);
        pScale = new JTextField(4);
        pBuyprice = new JTextField(5);

        JPanel pTop = new JPanel();
        pTop.add(new JLabel("Code"));
        pTop.add(pCode);
        pTop.add(new JLabel("Name"));
        pTop.add(pName);
        pTop.add(new JLabel("Line"));
        pTop.add(pLine);
        pTop.add(new JLabel("Scale"));
        pTop.add(pScale);
        pTop.add(new JLabel("Price"));
        pTop.add(pBuyprice);

        this.add("North",pTop);

        btnAll = new JButton("목록");
        btnAdd = new JButton("추가");
        btnDel = new JButton("삭제");
        btnSearch = new JButton("검색");

        JPanel pButton = new JPanel();
        pButton.add(btnAll);
        pButton.add(btnAdd);
        pButton.add(btnDel);
        pButton.add(btnSearch);

        this.add("South", pButton);

        String[] title = {"Code" , "Name","Line","Scale","Price"};
        tableModel = new DefaultTableModel(title,0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));

        showAllList();

    }

    public void showAllList(){

        tableModel.setRowCount(0);

        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "Select * from products";

        try{

            pstmt = connection.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while(rs.next()){

                Vector<String> data = new Vector<>();
                String code = rs.getString("productCode");
                String name = rs.getString("productName");
                String line = rs.getString("productLine");
                String scale = rs.getString("productScale");
                String price = rs.getString("buyPrice");

                data.add(code);
                data.add(name);
                data.add(line);
                data.add(scale);
                data.add(price);

                tableModel.addRow(data);

            }

        }
        catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.DbClose(rs,pstmt,connection);
        }

    }


    public static void main(String[] args) {
            Ex2_productsSwingCRUD ex = new Ex2_productsSwingCRUD();

    }


}
