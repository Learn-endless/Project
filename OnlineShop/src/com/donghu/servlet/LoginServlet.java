package com.donghu.servlet; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-19
 * Time: 11:04
 */

import com.alibaba.fastjson.JSON;
import com.donghu.dao.Dao;
import com.donghu.pojo.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置编码字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取request的参数
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //使用dao中的登录模块，通过返回结果判断登录状态
        int res = Dao.login(email, password);
        Result result = new Result();
        //成功登录
        if(res == 1){
            result.setFlag("success");
            //邮箱未注册
        }else if(res == -1){
            result.setFlag("fail");result.setData("邮箱未注册");
            //密码错误
        }else{
            result.setFlag("fail");result.setData("密码错误");
        }
        response.getWriter().append(JSON.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
