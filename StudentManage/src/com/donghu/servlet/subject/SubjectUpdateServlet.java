package com.donghu.servlet.subject; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-06
 * Time: 18:53
 */

import com.alibaba.fastjson.JSON;
import com.donghu.dao.SubjectDao;
import com.donghu.pojo.Result;

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
        String subject_id = request.getParameter("id");
        String subject_name = request.getParameter("name");
        String subject_credit = request.getParameter("credit");

        //将id和credit转换为int
        int id = Integer.parseInt(subject_id);
        int credit = Integer.parseInt(subject_credit);

        //调用dao层的修改方法，修改数据库的内容
        int res = SubjectDao.updateSubject(id,subject_name,credit);
//        //更新 session 中的值
//        ArrayList<HashMap<String, Object>> subjects = SubjectDao.selectSubjectList();
//        HttpSession session = request.getSession();
//        session.setAttribute("subjects",subjects);
//        response.sendRedirect("subjectList.jsp");

        Result result = new Result();
        if(res > 0){
            //代表修改成功
            result.setFlag("success");
        }else{
            //修改失败
            result.setFlag("fail");
        }
        response.getWriter().append(JSON.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
