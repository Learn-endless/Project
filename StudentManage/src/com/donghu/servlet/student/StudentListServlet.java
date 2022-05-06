package com.donghu.servlet.student; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-06
 * Time: 19:12
 */

import com.donghu.dao.StudentDao;
import com.donghu.dao.SubjectDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //调用dao层的学生查询方法
        ArrayList<HashMap<String, Object>> students = StudentDao.selectStudent();
        //为了防止第一次直接进入student列表，所以这里也需要获取一遍课程列表
        ArrayList<HashMap<String,Object>> subjects = SubjectDao.selectSubjectList();
        //存放到session中
        HttpSession session = request.getSession();
        session.setAttribute("students",students);
        session.setAttribute("subjects",subjects);
        response.sendRedirect("studentList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
