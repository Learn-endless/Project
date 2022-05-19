package com.donghu.servlet.subject; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-05
 * Time: 16:02
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

@WebServlet("/subjectAdd")
public class SubjectAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取请求数据
        String subject_name = request.getParameter("name");
        String subject_credit = request.getParameter("credit");

        //将学分数据类型转换为 int
        int credit = Integer.parseInt(subject_credit);
//        System.out.println(subject_name);
//        System.out.println(subject_credit);

        //调用dao层的新增方法
        int res = SubjectDao.insertSubject(subject_name, credit);
        System.out.println(res);    //打印下被影响的行数

        //重新更新session中的数据
        ArrayList<HashMap<String, Object>> subjects = SubjectDao.selectSubjectList();
        HttpSession session = request.getSession();
        session.setAttribute("subjects",subjects);
        response.sendRedirect("subjectList.jsp");
//        Result result = new Result();
//        if(res > 0){
//            result.setFlag("success");
//        }else{
//            result.setFlag("fail");
//        }
//        response.getWriter().append(JSON.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
