package com.donghu.servlet.student; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-06
 * Time: 19:59
 */

import com.alibaba.fastjson.JSON;
import com.donghu.dao.StudentDao;
import com.donghu.pojo.Result;

import javax.jnlp.IntegrationService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/studentAdd")
public class StudentAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //拿到新增学生的数据
        String student_name = request.getParameter("name");
        String student_gender = request.getParameter("gender");
        String student_subject = request.getParameter("subjectId");

        //转化类型
        int subjectId = Integer.parseInt(student_subject);
        //调用dao层的新增数据方法
        int res = StudentDao.insertStudent(student_name,student_gender,subjectId);

//        //更新session
//        ArrayList<HashMap<String, Object>> students = StudentDao.selectStudent();
//        HttpSession session = request.getSession();
//        session.setAttribute("students",students);
//        response.sendRedirect("studentList.jsp");

        Result result = new Result();
        if(res > 0){
            result.setFlag("success");
        }else{
            result.setFlag("fail");
        }
        response.getWriter().append(JSON.toJSONString(result));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
