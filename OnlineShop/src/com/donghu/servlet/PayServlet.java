package com.donghu.servlet; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-19
 * Time: 17:06
 */

import com.alibaba.fastjson.JSON;
import com.donghu.dao.Dao;
import com.donghu.pojo.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //拿到订单id和用户
        String orderIdStr = request.getParameter("orderId");
        String email = request.getParameter("email");

        //将订单id转换下类型
        int orderId = Integer.parseInt(orderIdStr);

        //使用dao层中的方法，将订单表单中的数据进行更新
        int res = Dao.pay(orderId);

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
