package com.donghu.servlet; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-19
 * Time: 9:51
 */

import com.alibaba.fastjson.JSON;
import com.donghu.dao.Dao;
import com.donghu.pojo.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1.从request获取参数
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        int res = 0;

        //3.调用dao层的方法，将用户的信息存放到数据库中。
        res = Dao.signUp(email, name, password);
        Result result = new Result();
        //新增成功
        if(res > 0){ result.setFlag("success"); }
        //邮箱已存在
        else{ result.setFlag("fail");result.setData("邮箱已注册");}
        response.getWriter().append(JSON.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
