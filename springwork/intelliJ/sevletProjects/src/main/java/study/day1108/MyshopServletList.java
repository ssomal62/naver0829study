package study.day1108;

import myshop.MyShopDto;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/cjhome/myshop/list")
public class MyshopServletList extends HttpServlet {

    // 경로들
    //1.   /프로젝트명/cjhome/myshop/list
    //2.   /프로젝트명/day1108/myshopList.jsp
    //3.리소스   /프로젝트명 /리소스 파일경로

    List<MyShopDto> list = new ArrayList<>();

    public MyshopServletList(){
        list.add(new MyShopDto(100,"스크런치","2.jpg",23000,"purple"));
        list.add(new MyShopDto(200,"구두","13.jpg",160000,"green"));
        list.add(new MyShopDto(300,"키링","11.jpg",18000,"black"));
        list.add(new MyShopDto(400,"스니커즈","26.jpg",178000,"blue"));
        list.add(new MyShopDto(500,"커튼","1.jpg",225000,"orange"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("total",list.size());
        request.setAttribute("list",list);
        request.setAttribute("today",new Date());

        //포워드
       RequestDispatcher rd = request.getRequestDispatcher("../../day1108/myshopList.jsp");
       rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
