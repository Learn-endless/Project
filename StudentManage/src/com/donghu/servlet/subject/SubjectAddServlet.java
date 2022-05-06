package com.donghu.servlet.subject; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-05
 * Time: 16:02
 */

import com.donghu.dao.SubjectDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/subjectAdd")
public class SubjectAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取请求数据
        String subject_name = request.getParameter("subject_id");
        String subject_credit = request.getParameter("subject_credit");

        //将学分数据类型转换为 int
        int credit = Integer.parseInt(subject_credit);

        //调用dao层的新增方法
        int result = SubjectDao.insertSubject(subject_name, credit);
        System.out.println(result);    //打印下被影响的行数

        //重新更新session中的数据
        ArrayList<HashMap<String, Object>> subjects = SubjectDao.selectSubjectList();
        HttpSession session = request.getSession();
        session.setAttribute("subjects",subjects);
        response.sendRedirect("subjectList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
