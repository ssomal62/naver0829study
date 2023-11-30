package study.day1107;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/index.jsp")
public class HelloSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request에 각종 정보를 저장

        //result.jsp로 포워드

        //포워드의 특징 : 1. url 주소 유지. 2. request 객체 유지. 3. response 객체 유지.

        List<String> list = new ArrayList<>();
        list.add("red");
        list.add("green");
        list.add("magenta");
        list.add("orange");
        list.add("blue");

        request.setAttribute("list",list);
        request.setAttribute("today",new Date());
        request.setAttribute("message","Have a Good Day!!!");

        //result1.jsp로 포워드
       // RequestDispatcher rd = request.getRequestDispatcher("./day1107/result3.jsp");
       // rd.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
