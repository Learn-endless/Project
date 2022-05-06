package com.donghu.servlet.student; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-06
 * Time: 21:01
 */

import com.donghu.dao.StudentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/toStudentModify")
public class ToStudentModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //拿到需要修改的学生ID
        String student_id = request.getParameter("id");
        //转化类型
        int id = Integer.parseInt(student_id);
        //调用dao层方法拿到ID对应的学生的信息(学生信息加课程信息)
        HashMap<String, Object> student = StudentDao.getById(id);
        //存放到session中
        HttpSession session = request.getSession();
        session.setAttribute("student",student);
        response.sendRedirect("studentUpdate.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
