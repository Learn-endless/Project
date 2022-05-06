package com.donghu.servlet.subject; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-06
 * Time: 18:53
 */

import com.donghu.dao.SubjectDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/subjectUpdate")
public class SubjectUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //接收所需要修改的数据
        String subject_id = request.getParameter("subject_id");
        String subject_name = request.getParameter("subject_name");
        String subject_credit = request.getParameter("subject_credit");

        //将id和credit转换为int
        int id = Integer.parseInt(subject_id);
        int credit = Integer.parseInt(subject_credit);

        //调用dao层的修改方法，修改数据库的内容
        SubjectDao.updateSubject(id,subject_name,credit);
        //更新 session 中的值
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
