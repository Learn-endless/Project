package com.donghu.servlet.subject; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-05
 * Time: 14:42
 */

import com.donghu.dao.SubjectDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/subjectList")
public class SubjectListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //从Dao层拿到 课程列表
        ArrayList<HashMap<String, Object>> subjects = SubjectDao.selectSubjectList();
        //获取Session 对象
        HttpSession session = request.getSession();
        //存放到session中
        session.setAttribute("subjects",subjects);
        //重定向
        response.sendRedirect("subjectList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
