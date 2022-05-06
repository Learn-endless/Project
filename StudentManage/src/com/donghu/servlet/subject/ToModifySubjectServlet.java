package com.donghu.servlet.subject; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-05
 * Time: 17:03
 */

import com.donghu.dao.SubjectDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/toModifySubject")
public class ToModifySubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取需要修改的课程ID
        String subject_id = request.getParameter("id");
        //通过课程ID获取课程数据
        int id = Integer.parseInt(subject_id);
        HashMap<String, Object> subject = SubjectDao.getById(id);

        //放到session中
        HttpSession session = request.getSession();
        session.setAttribute("subject",subject);
        response.sendRedirect("subjectUpdate.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
