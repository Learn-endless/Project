package com.donghu.servlet.student; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-06
 * Time: 22:14
 */

import com.alibaba.fastjson.JSON;
import com.donghu.dao.StudentDao;
import com.donghu.pojo.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/studentDelete")
public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取需要删除的学生id
        String student_id = request.getParameter("id");
        //转一下类型
        int id = Integer.parseInt(student_id);
        //调用dao层的方来在数据库中删除
        int res = StudentDao.deleteStudent(id);
//        //更新session中students的值
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
