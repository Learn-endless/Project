package com.donghu.servlet.subject; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-06
 * Time: 19:03
 */

import com.donghu.dao.SubjectDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/subjectDelete")
public class SubjectDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //接收一下需要删除的课程编号
        String subject_id = request.getParameter("id");
        //转换一下类型
        int id = Integer.parseInt(subject_id);

        //调用dao层的删除方法
        SubjectDao.deleteSubject(id);
        //更新session中的数据
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
